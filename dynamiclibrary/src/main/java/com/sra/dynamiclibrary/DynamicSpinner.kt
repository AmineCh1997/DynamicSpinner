package com.sra.dynamicspinnerlibrary

import android.R
import android.content.Context
import android.util.AttributeSet
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONArray




class DynamicSpinner  constructor(context: Context, attrs: AttributeSet? = null) : AppCompatSpinner(context, attrs)  {

    var strings : ArrayList<String>? = null

    fun fillDataFromUrl(url : String, key : String){
      val link = url
      val stringRequest =
          StringRequest(
              Request.Method.GET, link,
              Response.Listener { response ->
                  try {
                      println(response)
                      val jsonArray = JSONArray(response.toString())
                      if (jsonArray.length() > 0) {
                          prepareStrings(jsonArray,key)
                      }
                  } catch (e: Exception) {
                      e.printStackTrace()
                      throw e
                  }
              }, Response.ErrorListener {
              }
          )
      VolleySingleton.getInstance(context).addToRequestQueue(stringRequest)
  }

    fun prepareStrings(jsonArray : JSONArray, jsonkey : String) {
        strings = ArrayList()
        if (jsonArray.length() > 0) {
            for (i in 0 until jsonArray.length() step 1) {
                val jsonObject = jsonArray.getJSONObject(i)
                strings!!.add(jsonObject.optString(jsonkey))
            }
        }
        fillSpinner()
    }

    fun fillSpinner(){
        val dataAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            context,
            R.layout.simple_spinner_item,
            strings!!
        )
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        this.adapter = dataAdapter
    }





}