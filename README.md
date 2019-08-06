<p align="center">An app to track and manage various health indicators which will be analysed by big data technologies in order to provide insights.</p>

## Screenshots

<img src="https://github.com/Oana1234/Hector/blob/master/r2.jpg"  width="240px" height="460px" hspace="60"  />   <img src="https://github.com/Oana1234/Hector/blob/master/r1.jpg" width="240px" height="460px" />       


## Dependencies

dependencies {
implementation fileTree(dir: 'libs', include: ['*.jar'])

    // kotlin
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"

    // android support libraries
    implementation 'androidx.appcompat:appcompat:1.1.0-alpha05'
    implementation 'androidx.core:core-ktx:1.2.0-alpha01'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.google.android.material:material:1.1.0-alpha06'
    implementation 'androidx.vectordrawable:vectordrawable:1.0.1'
    implementation 'androidx.vectordrawable:vectordrawable-animated:1.0.0'
    implementation  'androidx.cardview:cardview:1.0.0'


    // database
    implementation 'androidx.room:room-rxjava2:2.1.0-beta01'
    kapt 'androidx.room:room-compiler:2.1.0-beta01'

    // network
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.4.0"

    // font
    implementation "uk.co.chrisjenx:calligraphy:2.2.0"

    // parser
    implementation "com.google.code.gson:gson:2.8.5"
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'

    // dependency injection
    implementation "com.google.dagger:dagger:2.19"
    kapt "com.google.dagger:dagger-compiler:2.19"
    kapt "com.google.dagger:dagger-android-processor:2.19"
    implementation "com.google.dagger:dagger-android-support:2.19"

    // reactive
    implementation "io.reactivex.rxjava2:rxjava:2.2.0"
    implementation "io.reactivex.rxjava2:rxandroid:2.1.0"

    // swipe view
    implementation "com.mindorks:placeholderview:0.6.1"

    // logger
    implementation "com.jakewharton.timber:timber:4.6.0"

    // dependencies for local unit tests
    testImplementation "junit:junit:4.12"
    testImplementation "org.mockito:mockito-core:2.23.0"
    kaptTest "com.google.dagger:dagger-compiler:2.19"

    // UI Testing
    androidTestImplementation "com.android.support.test.espresso:espresso-core:3.0.2"
    androidTestImplementation "com.android.support.test.espresso:espresso-intents:3.0.2"
    androidTestImplementation "org.mockito:mockito-core:2.23.0"
    kaptAndroidTest "com.google.dagger:dagger-compiler:2.19"

    // Android Kotlin Extension
    implementation 'androidx.core:core-ktx:1.0.2'

    implementation 'android.arch.navigation:navigation-fragment:1.0.0'

    // facebook login
    implementation 'com.facebook.android:facebook-android-sdk:4.42.0'

    /* Android Architecture Component - LiveData & ViewModel  */
    implementation 'android.arch.lifecycle:extensions:1.1.1'

    //compileOnly 'javax.annotation:jsr250-api:1.0'
    implementation 'androidx.viewpager:viewpager:1.0.0'

    implementation 'javax.xml.bind:jaxb-api:2.3.1'

    implementation 'com.github.amlcurran.showcaseview:library:5.4.3'

    // Bottom Navigation
    implementation 'com.github.ittianyu:BottomNavigationViewEx:2.0.4'

    //graph
    implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'

    //circle imageview
    implementation 'de.hdodenhof:circleimageview:3.0.0'

    //boom-menu
    implementation 'com.nightonke:boommenu:2.1.1'

    //glide
    implementation 'com.github.bumptech.glide:glide:4.4.0'
    kapt 'com.github.bumptech.glide:compiler:4.4.0'

    // Network debugging - Chuck
    debugImplementation 'com.readystatesoftware.chuck:library:1.1.0'
    releaseApi 'com.readystatesoftware.chuck:library-no-op:1.1.0'


}
