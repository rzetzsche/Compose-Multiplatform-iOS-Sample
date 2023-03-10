plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    android()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation("androidx.appcompat:appcompat:1.5.1")
                implementation("androidx.activity:activity-compose:1.6.1")
            }
        }
    }
}

android {
    compileSdk = androidVersions.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.plauzeware.compose_mp_ios"
        minSdk = androidVersions.versions.minSdk.get().toInt()
        targetSdk = androidVersions.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
