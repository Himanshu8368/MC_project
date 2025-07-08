import org.gradle.internal.impldep.org.jsoup.helper.DataUtil.load
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.plant_disease_detection"
    compileSdk = 35
    buildFeatures {
        compose = true
        buildConfig = true  // 👈 Add this line
    }

    defaultConfig {
        applicationId = "com.example.plant_disease_detection"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // 🔽 Added API key configuration START 🔽
        val localProperties = Properties().apply {
            val localPropertiesFile = File(rootProject.projectDir, "local.properties")
            if (localPropertiesFile.exists()) {
                load(localPropertiesFile.inputStream())
            }
        }
        buildConfigField("String", "OPENAI_API_KEY", "\"${localProperties.getProperty("OPENAI_API_KEY", "")}\"")
        // 🔼 Added API key configuration END 🔼
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Navigation Compose
    implementation (libs.androidx.navigation.compose)

    // PyTorch Mobile
    implementation (libs.pytorch.android)
    implementation (libs.pytorch.android.torchvision)
    implementation (libs.material)

    // Gson for JSON parsing
    implementation (libs.gson)

    // Image loading and camera
    implementation (libs.androidx.exifinterface)
    implementation (libs.androidx.lifecycle.viewmodel.compose)
    implementation (libs.androidx.lifecycle.runtime.ktx.v262)
    implementation (libs.androidx.material.icons.extended)
    // openai library
    implementation (libs.openai.client)
    implementation(libs.ktor.client.android)
    implementation (libs.ktor.client.content.negotiation)
    implementation (libs.ktor.serialization.kotlinx.json)
    implementation (libs.ktor.client.logging)

    // Testing
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation platform('androidx.compose:compose-bom:2023.03.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//
//    // Debug tools
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
}