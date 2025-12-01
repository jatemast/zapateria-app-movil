buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Android Gradle Plugin (AGP)
        classpath("com.android.tools.build:gradle:8.2.2")

        // Plugin de Hilt
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}

