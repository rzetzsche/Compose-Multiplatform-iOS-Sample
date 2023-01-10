dependencyResolutionManagement {
    versionCatalogs {
        create("androidVersions") {
            version("minSdk", "26")
            version("compileSdk", "33")
            version("targetSdk", "33")
            version("agpVersion", extra.get("agpVersion").toString())
        }
        create("libs") {
            version("kotlinVersion", extra.get("kotlinVersion").toString())
            version("ktor", "2.2.2")
            version("coroutines", "1.6.4")
            version("jb-compose", extra.get("composeVersion").toString())
            version("kodein", "7.16.0")
            version("sqldelight", extra.get("sqldelight").toString())
        }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    // define dependencies which are used in plugins and dependencies
    extra.set("kotlinVersion", "1.7.20")
    extra.set("agpVersion", "7.3.1")
    extra.set("composeVersion", "1.3.0-rc01")
    extra.set("sqldelight", "1.5.4")

    plugins {
        kotlin("jvm").version(extra.get("kotlinVersion").toString())
        kotlin("multiplatform").version(extra.get("kotlinVersion").toString())
        kotlin("plugin.serialization").version(extra.get("kotlinVersion").toString())
        kotlin("android").version(extra.get("kotlinVersion").toString())
        id("com.android.base").version(extra.get("agpVersion").toString())
        id("com.android.application").version(extra.get("agpVersion").toString())
        id("com.android.library").version(extra.get("agpVersion").toString())
        id("org.jetbrains.compose").version(extra.get("composeVersion").toString())
        id("com.squareup.sqldelight").version(extra.get("sqldelight").toString())
    }
}

rootProject.name = "compose_mp_ios"

include(":androidApp")
include(":shared")
include(":desktopApp")
include(":jsApp")