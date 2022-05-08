plugins {
	id(Plugins.ANDROID_APPLICATION)
	id(Plugins.KOTLIN_ANDROID)
}

android {
	compileSdkVersion(Settings.COMPILE_SDK_VERSION)
	buildToolsVersion(Settings.BUILD_TOOLS_VERSION)
	buildFeatures.viewBinding = true

	defaultConfig {
		applicationId = Settings.APPLICATION_ID
		minSdkVersion(Settings.MIN_SDK_VERSION)
		targetSdkVersion(Settings.TARGET_SDK_VERSION)
		versionCode = Settings.VERSION_CODE
		versionName = Settings.VERSION_NAME
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	packagingOptions {
		exclude("META-INF/*.kotlin_module")
	}

	kotlinOptions {
		jvmTarget = Settings.JVM_TARGET
	}
}

dependencies {
	implementation(Dependencies.Kotlin.KOTLIN_STANDARD_LIBRARY)
	implementation(Dependencies.CORE)
	implementation(Dependencies.APP_COMPAT)
	implementation(Dependencies.MATERIAL)
	implementation(Dependencies.CONSTRAINT_LAYOUT)
	implementation(Dependencies.Koin.KOIN_CORE)
	implementation(Dependencies.Koin.KOIN_ANDROID)
	implementation(Dependencies.CICERONE)

	implementation(Dependencies.RETROFIT)
	implementation(Dependencies.MOSHI)
	implementation(Dependencies.MOSHI_RETROFIT)
	implementation(Dependencies.RETROFIT_SCALARS)

	implementation(project(Modules.Features.HOME))
	implementation(project(Modules.Features.MOVIE_DETAILS))
	implementation(project(Modules.Shared.Movie.DOMAIN))
	implementation(project(Modules.Shared.Movie.DATA))
}