package com.raudonikis.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.raudonikis.auth.authprovider.AuthProvider
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val authProvider: AuthProvider) : ViewModel() {

    private val _loginEvent = LiveEvent<Boolean>()
    val loginEvent: LiveData<Boolean> = _loginEvent

    fun signIn(email: String, password: String) {
        authProvider.signInWithEmailAndPassword(email, password,
            onSuccess = { _loginEvent.postValue(true) },
            onFailure = { _loginEvent.postValue(false) }
        )
    }
}