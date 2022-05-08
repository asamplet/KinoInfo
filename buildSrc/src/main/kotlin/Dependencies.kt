object Dependencies {

	private object Versions {

		const val KOTLIN = "1.5.31"
		const val GRADLE = "7.0.4"
		const val MATERIAL = "1.3.0"
		const val CONSTRAINT_LAYOUT = "2.0.4"
		const val CORE = "1.3.2"
		const val APP_COMPAT = "1.2.0"
		const val KOIN = "3.0.1"
		const val CICERONE = "7.0"
		const val COROUTINES_CORE = "1.5.0"
		const val FRAGMENT = "1.2.5"
		const val PRESENTER = "2.2.2"
		const val RETROFIT = "2.9.0"
		const val MOSHI = "1.13.0"
		const val GLIDE = "4.13.0"
	}

	const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
	const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
	const val RETROFIT_SCALARS = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT}"
	const val MOSHI_RETROFIT = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

	const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
	const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"

	const val PRESENTER = "com.github.moxy-community:moxy-androidx:${Versions.PRESENTER}"
	const val PRESENTER_KTX = "com.github.moxy-community:moxy-ktx:${Versions.PRESENTER}"
	const val PRESENTER_COMPILER = "com.github.moxy-community:moxy-compiler:${Versions.PRESENTER}"

	const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
	const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
	const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
	const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
	const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
	const val CICERONE = "com.github.terrakok:cicerone:${Versions.CICERONE}"
	const val FRAGMENT = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"

	object Kotlin {

		const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
		const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
		const val KOTLIN_STANDARD_LIBRARY =
			"org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
		const val COROUTINES_CORE =
			"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_CORE}"
	}

	object Koin {

		const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
		const val KOIN_CORE = "io.insert-koin:koin-core-ext:${Versions.KOIN}"
	}
}