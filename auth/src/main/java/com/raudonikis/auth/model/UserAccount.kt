package com.raudonikis.auth.model

import android.net.Uri

data class UserAccount(
    val name: String?,
    val email: String?,
    val photoUrl: Uri?,
    val isEmailVerified: Boolean
)