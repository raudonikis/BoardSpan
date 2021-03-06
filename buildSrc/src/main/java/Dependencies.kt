object Versions {
    const val navigation = "2.3.0-alpha04"
    const val kotlin = "1.2.0"
    const val app_compat = "1.1.0"
    const val constraint_layout = "1.1.3"
    const val firebase = "19.3.0"
    const val google_play = "18.0.0"
    const val dagger = "2.27"
    const val timber = "4.7.1"
    const val material = "1.1.0"
    const val live_event = "1.2.0"
}

object Modules {
    const val app = ":app"
    const val auth = ":auth"
    const val core = ":core"
    const val login = ":login"
    const val games = ":games"
}

object Sdk {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
}

object Releases {
    const val applicationId = "com.raudonikis.boardspan"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.kotlin}"
}

object Support {
    const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val live_event = "com.github.hadilq.liveevent:liveevent:${Versions.live_event}"
}

object Navigation {
    const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Firebase {
    const val auth = "com.google.firebase:firebase-auth:${Versions.firebase}"
    const val google_play = "com.google.android.gms:play-services-auth:${Versions.google_play}"
}

object Dagger {
    const val main = "com.google.dagger:dagger:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}