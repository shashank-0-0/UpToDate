plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.network"
    compileSdk = 33
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")

    //Ktor dependencies
    val ktor_version = "1.6.4"
    val serialization_version = "1.3.0"

    implementation("io.ktor:ktor-client-core:$ktor_version")

//  HTTP engine: The HTTP client used to perform network requests.
    implementation("io.ktor:ktor-client-android:$ktor_version")

//  The serialization engine used to convert objects to and from JSON.
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")

//  Logging
    implementation("io.ktor:ktor-client-logging:$ktor_version")

//    Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    implementation(project(":core:domain"))
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}