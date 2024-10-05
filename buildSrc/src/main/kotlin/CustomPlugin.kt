import Versions.compileSdkVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.application")
        target.plugins.apply("org.jetbrains.kotlin.android")
        target.plugins.apply("org.jetbrains.kotlin.kapt")
        target.plugins.apply("org.jetbrains.kotlin.plugin.compose")

        target.extensions.getByType(BaseExtension::class.java).apply {
            compileSdkVersion(Versions.compileSdkVersion)

            defaultConfig {
                minSdkVersion(Versions.minSdkVersion)
                targetSdkVersion(Versions.targetSdkVersion)
                versionCode = Versions.versionCode
                versionName = Versions.versionName
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            packagingOptions {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

        }



        target.dependencies {
            "implementation"(platform(Dependencies.composeBom))
            "implementation"(Dependencies.kotlinStdlib)
            "implementation"(Dependencies.composeUi)
            "implementation"(Dependencies.composeMaterial)
            "implementation"(Dependencies.composeUiToolingPreview)
            "implementation"(Dependencies.lifecycleRuntimeKtx)
            "implementation"(Dependencies.activityCompose)
            "androidTestImplementation"(platform(Dependencies.composeBom))
            "androidTestImplementation"(Dependencies.composeUiTestJunit4)
        }
    }
}