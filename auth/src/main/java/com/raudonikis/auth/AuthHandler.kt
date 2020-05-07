package com.raudonikis.auth

import com.raudonikis.auth.authprovider.AuthProvider
import javax.inject.Inject

class AuthHandler @Inject constructor(private val auth: AuthProvider) {

    fun isUserSignedIn() = auth.isUserSignedIn()
}