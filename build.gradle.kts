/*plugins {
    id("com.google.devtools.ksp") version "1.9.0" apply false
}*/
buildscript{
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        google()
    }
    dependencies{
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")

    }
}