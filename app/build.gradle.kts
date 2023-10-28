import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    // id("com.google.devtools.ksp")
}

baseConfig()

compose()

android {
    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    kapt {
        correctErrorTypes = true
        useBuildCache = true
    }
}

dependencies {
    //implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.10"))
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.10")

    androidBase()
    compose()
    room()
    kapt("androidx.room:room-compiler:2.6.0")
    implementation("androidx.room:room-ktx:$room")
    dataStore()

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.10")

}