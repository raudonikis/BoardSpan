package com.raudonikis.login.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.raudonikis.auth.authprovider.AuthProvider
import com.raudonikis.core.inputvalidation.ValidationResult
import com.raudonikis.core.inputvalidation.ValidationUtils
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val authProvider: AuthProvider) : ViewModel() {

    private val _loginEvent = LiveEvent<Boolean>()
    val loginEvent: LiveData<Boolean> = _loginEvent

    private val _emailValidator = LiveEvent<ValidationResult>()
    val emailValidator: LiveData<ValidationResult> = _emailValidator

    private val _passwordValidator = LiveEvent<ValidationResult>()
    val passwordValidator: LiveData<ValidationResult> = _passwordValidator

    fun signIn(email: String, password: String) {
        if(!areInputsValid(email, password)) return
        authProvider.signInWithEmailAndPassword(email, password,
            onSuccess = { _loginEvent.postValue(true) },
            onFailure = { _loginEvent.postValue(false) }
        )
    }

    private fun areInputsValid(email: String, password: String): Boolean {
        val emailValidationResult = ValidationUtils.isEmailInputValid(email)
        val passwordValidationResult = ValidationUtils.isPasswordInputValid(password)
        _emailValidator.postValue(emailValidationResult)
        _passwordValidator.postValue(passwordValidationResult)
        return emailValidationResult == ValidationResult.VALID && passwordValidationResult == ValidationResult.VALID
    }
}