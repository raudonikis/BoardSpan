package com.raudonikis.core.extensions

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.clearErrorMessage() {
    error = ""
}

fun TextInputLayout.getInput(): String {
    return editText?.text.toString()
}