buildscript {
    val agp_version by extra("8.2.2")
    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    alias(libs.plugins.compose.compiler) apply false
    //id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
}