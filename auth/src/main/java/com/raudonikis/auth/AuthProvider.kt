package com.raudonikis.auth

import com.raudonikis.auth.model.UserAccount

interface AuthProvider {

    fun signInWithEmailAndPassword(email: String, password: String)
    fun signUpWithEmailAndPassword(email: String, password: String)
    fun getUserAccount(): UserAccount?
    fun isUserSignedIn(): Boolean
}