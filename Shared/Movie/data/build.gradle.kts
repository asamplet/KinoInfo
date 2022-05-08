plugins {
	id(Plugins.ANDROID_LIBRARY)
	id(Plugins.KOTLIN_ANDROID)
	id(Plugins.KOTLIN_KAPT)
}

android {
	compileSdkVersion(Settings.COMPILE_SDK_VERSION)
	buildToolsVersion(Settings.BUILD_TOOLS_VERSION)
	buildFeatures.viewBinding = true

	defaultConfig {
		minSdkVersion(Settings.MIN_SDK_VERSION)
		targetSdkVersion(Settings.TARGET_SDK_VERSION)
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = Settings.JVM_TARGET
	}
}

dependencies {
	implementation(Dependencies.Kotlin.COROUTINES_CORE)
	implementation(Dependencies.Kotlin.KOTLIN_STANDARD_LIBRARY)
	implementation(Dependencies.Koin.KOIN_ANDROID)
	implementation(Dependencies.RETROFIT)
	implementation(Dependencies.MOSHI)
	implementation(Dependencies.MOSHI_RETROFIT)

	implementation(project(Modules.Shared.Movie.DOMAIN))
}