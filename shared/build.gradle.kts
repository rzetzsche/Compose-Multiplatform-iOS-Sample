import org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_13_PRO

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
}

version = "1.0-SNAPSHOT"

kotlin {
    android()
    jvm("desktop")
    iosArm64("uikitArm64") {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics",
                    "-Xverify-compiler=false"
                )
            }
        }
    }
    iosX64("uikitX64") {
        binaries {
            executable {
                entryPoint = "main"
                freeCompilerArgs += listOf(
                    "-linker-option", "-framework", "-linker-option", "Metal",
                    "-linker-option", "-framework", "-linker-option", "CoreText",
                    "-linker-option", "-framework", "-linker-option", "CoreGraphics",
                    "-Xverify-compiler=false"
                )
            }
        }
    }
    js(IR) {
        browser()
        binaries.executable()
    }

    cocoapods {
        summary = "Shared code for the sample"
        homepage = "https://github.com/JetBrains/compose-jb"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:${libs.versions.ktor.get()}")
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.animation)
                implementation("org.jetbrains.compose.components:components-resources:1.3.0-beta04-dev879")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
                api("moe.tlaster:precompose:1.3.13")
                implementation("org.kodein.di:kodein-di:${libs.versions.kodein.get()}")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.5.1")
                implementation("androidx.core:core-ktx:1.9.0")
                implementation("io.ktor:ktor-client-okhttp:${libs.versions.ktor.get()}")
                implementation(compose.ui)
                implementation(compose.preview)
                implementation(compose.uiTooling)
            }
        }
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val uikitMain by creating {
            dependsOn(nativeMain)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:${libs.versions.ktor.get()}")
            }
        }
        val uikitArm64Main by getting {
            dependsOn(uikitMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-iosarm64:${libs.versions.coroutines.get()}")
            }
        }
        val uikitX64Main by getting {
            dependsOn(uikitMain)
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:${libs.versions.coroutines.get()}")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
                implementation(compose.preview)
                implementation(compose.uiTooling)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:${libs.versions.coroutines.get()}")
                implementation("io.ktor:ktor-client-cio:${libs.versions.ktor.get()}")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${libs.versions.coroutines.get()}")
                implementation("io.ktor:ktor-client-js:${libs.versions.ktor.get()}")
            }
        }
    }
}

android {
    compileSdk = androidVersions.versions.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDir("src/commonMain/resources")
    defaultConfig {
        minSdk = androidVersions.versions.minSdk.get().toInt()
        targetSdk = androidVersions.versions.targetSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

compose.experimental {
    web.application {}
    uikit.application {
        bundleIdPrefix = "com.plauzeware"
        projectName = "compose_mp_ios"
        deployConfigurations {
            simulator("IPhone13") {
                //Usage: ./gradlew iosDeployIPhone8Debug
                device = IPHONE_13_PRO
            }
            connectedDevice("Device") {
                //First need specify your teamId here, or in local.properties (compose.ios.teamId=***)
                teamId = "B73GNWU6TT"
                //Usage: ./gradlew iosDeployDeviceRelease
            }
        }
    }

}


tasks.withType<ProcessResources> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackCli.version = "4.10.0"
        nodeVersion = "16.0.0"
    }
}
