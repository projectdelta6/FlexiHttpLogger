plugins {
	alias(libs.plugins.android.library)
	alias(libs.plugins.kotlin.android)
}

// For JitPack
group = "com.github.projectdelta6"

android {
	namespace = "com.duck.flexilogger.flexihttplogger"
	compileSdk = libs.versions.compileSdk.get().toInt()

	defaultConfig {
		minSdk = libs.versions.minSdk.get().toInt()

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
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
		sourceCompatibility = JavaVersion.VERSION_17
		targetCompatibility = JavaVersion.VERSION_17
	}

	kotlin {
		jvmToolchain(17)
	}
}

dependencies {
	// Use version catalog references for dependencies
	implementation(libs.androidx.core.ktx)

	// External dependencies not in the catalog yet
	api(libs.flexilogger)
	api(libs.logging.interceptor)

	// Test dependencies from version catalog
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.test.ext)
	androidTestImplementation(libs.espresso.core)
}
