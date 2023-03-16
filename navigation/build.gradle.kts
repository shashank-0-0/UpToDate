plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
//
android {
    namespace = "com.example.navigation"
    compileSdk = 33
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

dependencies {
    val coroutineVersion = "1.6.4"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("androidx.navigation:navigation-common-ktx:2.5.3")

//    Hilt
    implementation("com.google.dagger:hilt-android:2.44")
}