object Versions {
    const val navigation = "2.3.0-alpha04"
    const val kotlin = "1.2.0"
    const val app_compat = "1.1.0"
    const val constraint_layout = "1.1.3"
    const val firebase = "19.3.0"
    const val google_play = "18.0.0"
    const val dagger = "2.27"
}

object Kotlin {
    const val core = "androidx.core:core-ktx:${Versions.kotlin}"
}

object Support {
    const val app_compat = "androidx.appcompat:appcompat:${Versions.app_compat}"
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
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