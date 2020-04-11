package com.raudonikis.login.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent
import com.raudonikis.auth.authprovider.AuthProvider
import com.raudonikis.core.inputvalidation.ValidationResult
import com.raudonikis.core.inputvalidation.ValidationUtils
import javax.inject.Inject

class SignUpViewModel @Inject constructor(private val authProvider: AuthProvider) : ViewModel() {

    private val _signUpEvent = LiveEvent<Boolean>()
    val signUpEvent: LiveData<Boolean> = _signUpEvent

    private val _emailValidator = LiveEvent<ValidationResult>()
    val emailValidator: LiveData<ValidationResult> = _emailValidator

    private val _passwordValidator = LiveEvent<ValidationResult>()
    val passwordValidator: LiveData<ValidationResult> = _passwordValidator

    private val _passwordConfirmValidator = LiveEvent<ValidationResult>()
    val passwordConfirmValidator: LiveData<ValidationResult> = _passwordConfirmValidator

    fun signIn(email: String, password: String, confirmPassword: String) {
        if (!areInputsValid(email, password, confirmPassword)) return
        authProvider.signUpWithEmailAndPassword(email, password,
            onSuccess = { _signUpEvent.postValue(true) },
            onFailure = { _signUpEvent.postValue(false) })
    }

    private fun areInputsValid(email: String, password: String, confirmPassword: String): Boolean {
        val emailValidationResult = ValidationUtils.isEmailInputValid(email)
        val passwordValidationResult = ValidationUtils.isPasswordInputValid(password)
        val passwordConfirmValidationResult =
            ValidationUtils.isPasswordConfirmInputValid(password, confirmPassword)
        _emailValidator.postValue(emailValidationResult)
        _passwordValidator.postValue(passwordValidationResult)
        _passwordConfirmValidator.postValue(passwordConfirmValidationResult)
        return emailValidationResult == ValidationResult.VALID &&
                passwordValidationResult == ValidationResult.VALID &&
                passwordConfirmValidationResult == ValidationResult.VALID
    }
}