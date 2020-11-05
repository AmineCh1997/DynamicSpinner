# DynamicSpinner

Spinner filled dynamically if you provide it with your GET_API ! 

# How to use ?

in your root build.gradle : 

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Add the dependency :  

	dependencies {
	        implementation 'com.github.AmineCh1997:DynamicSpinner:Tag'
	}

Code : 

              <com.sra.bkfood.dynamicspinnerlibrary.DynamicSpinner
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:id="@+id/dynamicspinner" />

       YourSpinner.fillDataFromUrl(GET PATH,StringKey)

               


# Android UI 

<img src="https://zupimages.net/up/20/45/bk4i.png" width="250" height="450">
