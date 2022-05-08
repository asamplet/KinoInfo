buildscript {
	repositories {
		google()
		jcenter()
	}
	dependencies {
		classpath(Dependencies.GRADLE)
		classpath(Dependencies.Kotlin.KOTLIN)
	}
}

allprojects {
	repositories {
		google()
		jcenter()
	}
}