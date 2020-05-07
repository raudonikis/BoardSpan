package com.raudonikis.auth.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.raudonikis.auth.enums.AuthState
import javax.inject.Inject

class AuthHandlerViewModel @Inject constructor(private val auth: FirebaseAuth) : ViewModel() {

    val authenticationEvent = MutableLiveData<AuthState>()

    fun checkAuthState() {
        when {
            auth.currentUser != null -> authenticationEvent.postValue(AuthState.AUTHORIZED)
            else -> authenticationEvent.postValue(AuthState.UNAUTHORIZED)
        }
    }
}