package com.raudonikis.core.extensions

import com.raudonikis.core.inputvalidation.RegexExpressions

fun String.isValidEmailInput(): Boolean {
    val isValidEmailRegex = RegexExpressions.emailRegex.toRegex()
    return isValidEmailRegex.matches(this)
}

fun String.isInvalidEmailInput(): Boolean {
    return !isValidEmailInput()
}