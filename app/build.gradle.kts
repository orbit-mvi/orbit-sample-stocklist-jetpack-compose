/*
 * Copyright 2021 Mikołaj Leszczyński & Appmattus Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 30
    defaultConfig {
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        applicationId = "org.orbitmvi.orbit.sample.stocklist.compose"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0"
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    testOptions.unitTests.isIncludeAndroidResources = true

    packagingOptions {
        resources {
            excludes.addAll(
                listOf(
                    "META-INF/INDEX.LIST",
                    "META-INF/io.netty.versions.properties"
                )
            )
        }
    }

    sourceSets {
        get("main").java.srcDir("src/main/kotlin")
        get("test").java.srcDir("src/test/kotlin")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.orbit-mvi:orbit-core:4.1.3")
    implementation("org.orbit-mvi:orbit-viewmodel:4.1.3")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("com.lightstreamer:ls-android-client:4.2.5")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha02")

    // Dependency Injection
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    // Jetpack Compose
    implementation("androidx.activity:activity-compose:1.3.0")
    implementation("androidx.compose.ui:ui:1.0.0")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.0")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.0.0")
    // Material Design
    implementation("androidx.compose.material:material:1.0.0")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.0.0")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha05")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
}
