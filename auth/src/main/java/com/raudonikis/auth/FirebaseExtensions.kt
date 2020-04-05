package com.raudonikis.auth

import com.google.firebase.auth.FirebaseUser
import com.raudonikis.auth.model.UserAccount

fun FirebaseUser.toUserAccount(): UserAccount {
    return UserAccount(
        this.displayName,
        this.email,
        this.photoUrl,
        this.isEmailVerified
    )
}