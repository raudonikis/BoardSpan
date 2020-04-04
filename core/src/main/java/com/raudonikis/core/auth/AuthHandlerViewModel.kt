package com.raudonikis.core.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthHandlerViewModel @Inject constructor(private val auth: FirebaseAuth) :
    ViewModel() {

    val navigationEvent = MutableLiveData<AuthState>()

    init {
        when {
            auth.currentUser != null -> navigationEvent.postValue(AuthState.AUTHORIZED)
            else -> navigationEvent.postValue(AuthState.UNAUTHORIZED)
        }
    }
}