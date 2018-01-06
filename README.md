# Dagger2 With Retrofit and Picasso

![ic_launcher](https://user-images.githubusercontent.com/11782272/34640805-c2ddaf2c-f31f-11e7-8323-9241ba02f0cd.png)

## How to use
First Need to add dependency in your Gradle. 

   //retrofit
    compile 'com.squareup.retrofit2:retrofit:2.3.0'
    
  //Gson converter   
    compile 'com.google.code.gson:gson:2.8.1'
    compile 'com.squareup.retrofit2:converter-gson:2.3.0'
    compile 'org.parceler:parceler-api:1.1.9'
    annotationProcessor 'org.parceler:parceler:1.1.9'
    
   //ok http
    compile 'com.squareup.okhttp3:logging-interceptor:3.9.1'
    compile 'com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0'
    
   //picasso
    compile 'com.squareup.picasso:picasso:2.5.2'
    
   //dagger2
    compile 'com.google.dagger:dagger-android:2.11'
    compile 'com.google.dagger:dagger-android-support:2.11'
    
   // if you use the support libraries
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.11'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.11'
