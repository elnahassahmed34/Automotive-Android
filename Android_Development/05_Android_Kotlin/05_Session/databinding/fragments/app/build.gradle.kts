plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.fragments"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fragments"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Enable data binding
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit and Gson for network calls
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")

    // Image loading libraries
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.squareup.picasso:picasso:2.8")

    // Android WorkManager for background tasks
    val work_version = "2.8.0"
    implementation("androidx.work:work-runtime-ktx:$work_version")

    // Data Binding runtime (automatically managed by the Android Gradle Plugin)
    implementation("androidx.databinding:databinding-runtime:7.0.0")

    // Remove kapt for databinding-compiler as it's automatically handled
}
