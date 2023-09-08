plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.core"
    compileSdk = 34

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // TODO: move constants to separate module
    val core_ctx_version = "1.10.1"
    val app_compat_version = "1.6.1"
    val activity_compose_version = "1.7.2"
    val compose_version = "1.5.0"

    val material3_version = "1.1.1"

    val lifecycle_ktx_version = "2.6.1"

    val nav_version = "2.7.1"
    val koin_version = "3.1.5"
    val retrofit_version = "2.9.0"

    val coroutines_version = "1.7.1"

    api("androidx.core:core-ktx:$core_ctx_version")
    api("androidx.appcompat:appcompat:$app_compat_version")
    api("androidx.activity:activity-compose:$activity_compose_version")
    api("androidx.compose.ui:ui:$compose_version")
    api("androidx.compose.ui:ui-graphics:$compose_version")
    api("androidx.compose.ui:ui-tooling-preview:$compose_version")
    api("androidx.compose.material3:material3:$material3_version")
    api("androidx.compose.material:material:$compose_version")

    api("androidx.legacy:legacy-support-v4:1.0.0")
    api("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_ktx_version")
    api("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_ktx_version")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_ktx_version")

    api("androidx.navigation:navigation-fragment-ktx:$nav_version")
    api("androidx.navigation:navigation-ui-ktx:$nav_version")
    api("androidx.navigation:navigation-compose:$nav_version")

    api("com.squareup.retrofit2:retrofit:$retrofit_version")
    api("com.squareup.retrofit2:converter-gson:$retrofit_version")

    api("io.insert-koin:koin-android:$koin_version")
    api("io.insert-koin:koin-androidx-compose:$koin_version")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    testImplementation("io.mockk:mockk:1.12.4")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")
}