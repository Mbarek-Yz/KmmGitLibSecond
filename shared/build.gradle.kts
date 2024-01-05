import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
    kotlin("native.cocoapods") version "1.9.21"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        android {
            publishLibraryVariants("release", "debug")
            publishLibraryVariantsGroupedByFlavor = true
        }
    }
    val xcf = XCFramework()
    jvm()
    js()
    mingwX64()
    linuxX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    val publicationsFromMainHost =
        listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"
    publishing {
        publications {
            matching { it.name in publicationsFromMainHost }.all {
                val targetPublication = this@all
                tasks.withType<AbstractPublishToMaven>()
                    .matching { it.publication == targetPublication }
                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
            }
        }
    }

        cocoapods {
            summary = "Some description for the Shared Module"
            homepage = "Link to the Shared Module homepage"
            version = "1.0"
            ios.deploymentTarget = "16.0"
            framework {
                baseName = "shared"
                isStatic = true
            }
        }

        sourceSets {
            commonMain.dependencies {
                //put your multiplatform dependencies here
                implementation ("androidx.core:core-ktx:1.7.0")

            }
            commonTest.dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }

    android {
        namespace = "com.example.kmmgitlib"
        compileSdk = 34
        defaultConfig {
            minSdk = 24
        }
    }
