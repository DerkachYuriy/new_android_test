object Versions {

    const val appCompat = "1.0.2"
    const val coreKtx = "1.0.1"
    const val constraintLayout = "1.1.3"
    const val lifecycleVersion = "2.2.0-beta01"
    const val navVersion = "2.1.0-alpha02"

    const val koin = "2.0.0-rc-2"

    const val retrofit = "2.5.0"
    const val okio = "2.2.2"
    const val okHttpLoggingInterceptor = "3.14.0"
    const val retrofitRxJavaAdapter = "2.5.0"
    const val retrofitCoroutinesAdapter = "0.9.2"
    const val moshi = "1.8.0"
    const val retrofitMoshiConverter = "2.4.0"

    const val rxJava = "2.2.8"
    const val rxAndroid = "2.0.2"
    const val rxKotlin = "2.3.0"
    const val kotlinCoroutines = "1.3.0"

    const val glide = "4.11.0"
    const val gson = "2.8.5"

    const val junit5 = "5.4.2"
    const val espressoCore = "3.1.1"
    const val spek = "2.0.2"
    const val mockitoKotlin = "2.1.0"

    const val junitImpl = "4.12"
    const val junit = "1.1.1"

    const val timber = "4.7.1"

    const val recyclerview = "1.1.0"
    const val material = "1.0.0"

    const val circularimageview = "4.1.1"

    const val room = "2.2.3"
}

object Dependencies {

    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${ProjectProps.kotlin}"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutines}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${ProjectProps.kotlin}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val nav = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinScopes = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModels = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okio = "com.squareup.okio:okio:${Versions.okio}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJavaAdapter}"
    const val retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitMoshiConverter}"

    const val junitApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    const val junitParameterizedTests = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    const val spekDsl = "org.spekframework.spek2:spek-dsl-jvm:${Versions.spek}"
    const val spekRunner = "org.spekframework.spek2:spek-runner-junit5:${Versions.spek}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val junitImpl = "junit:junit:${Versions.junitImpl}"
    const val junit = "androidx.test.ext:junit:${Versions.junit}"

    const val circularimageview = "com.mikhaellopez:circularimageview:${Versions.circularimageview}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomRx = "androidx.room:room-rxjava2:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

}

object ProjectProps {

    const val kotlin = "1.3.21"
    const val minSdk = 22
    const val compileSdk = 29
    const val targetSdk = 29
    const val buildTools = "29.0.2"
    const val applicationId = "com.android.calculateworkerhours"
}