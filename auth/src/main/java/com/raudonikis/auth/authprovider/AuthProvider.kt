package com.raudonikis.auth.authprovider

import com.raudonikis.auth.model.UserAccount

interface AuthProvider {

    fun signInWithEmailAndPassword(email: String, password: String, onSuccess: () -> Unit, onFailure: () -> Unit)
    fun signUpWithEmailAndPassword(email: String, password: String, onSuccess: () -> Unit, onFailure: () -> Unit)
    fun getUserAccount(): UserAccount?
    fun isUserSignedIn(): Boolean
}