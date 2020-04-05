package com.raudonikis.core.inputvalidation

import com.raudonikis.core.extensions.isInvalidEmailInput

object ValidationUtils {

    fun isEmailInputValid(email: String): ValidationResult {
        return when {
            email.isEmpty() -> ValidationResult.EMPTY
            email.isInvalidEmailInput() -> ValidationResult.INVALID
            else -> ValidationResult.VALID
        }
    }

    fun isPasswordInputValid(password: String): ValidationResult {
        return when {
            password.isEmpty() -> ValidationResult.EMPTY
            else -> ValidationResult.VALID
        }
    }
}