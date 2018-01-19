# Dagger2 With Retrofit and Picasso

![ic_launcher](https://user-images.githubusercontent.com/11782272/34640805-c2ddaf2c-f31f-11e7-8323-9241ba02f0cd.png)

## What is Dagger 2
  Dagger 2 is a library which helps the developer to implement a pattern of Dependency Injection (one specific form of Inversion of control). Dagger build constructor arguments to inject objects at runtime uses @Qualifiers to differentiate multiple clients with same return type and @Scope to prevent multiple objects creation of the same type and make Singleton. 
  


## Inversion of control (IoC) principles
This is a process to provide any program component with the external dependence. 

1. The modules of top levels shouldn’t depend on modules of the lower levels. The modules of all levels should depend on abstractions.
2. The abstractions shouldn’t depend on details. The details should depend on abstractions.

### Design disadvantages to be eliminated with IoC

1. Rigidity. If we change one module the other modules are changed too.
2. Fragility. If we change one part of program the other parts will have got uncontrolled errors.
3. Immobility. The single module can be hardly separated from the rest part of the application to be used again.

  ![ic245808](https://user-images.githubusercontent.com/11782272/34641049-f1b3e43e-f323-11e7-8071-142a3e202ea3.png)
####  More About IoC   
  <a href="https://msdn.microsoft.com/en-us/library/ff921087.aspx">Here</a> you can find full article about Inversion Of Control.

## Base elements (annotations) of Dagger 2

1. @Inject — base annotation whereby the “dependency is requested”
2. @Module — classes which methods “provide dependencies”
3. @Provide — methods inside @Module, which “tell Dagger how we want to build and present a dependency“
4. @Component — bridge between @Inject and @Module
5. @Scope — enables to create global and local singletons
6. @Qualifier — if different objects of the same type are necessary.

## How to use
Need to add dependency in your Gradle.   
   //dagger2
   
    compile 'com.google.dagger:dagger-android:2.11'
    compile 'com.google.dagger:dagger-android-support:2.11'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.11'
   // if you use the support libraries
   
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.11'    
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
  
