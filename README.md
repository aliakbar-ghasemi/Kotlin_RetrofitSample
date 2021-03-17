# Kotlin Retrofit Sample
The sample of rest api in kotlin

---

## Add dependencies to your project

```
dependencies {

    def lifecycle_version = "2.2.0"
    // - - ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // - - LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

    // - - Retrofit2
    def retrofit_version = "2.9.0"
    def logging_version = "4.3.1"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:okhttp:$logging_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$logging_version"

    // - - WP7 Progress Bar
    implementation 'com.github.shadowalker77:wp7progressbar:1.0.5'

}

```
