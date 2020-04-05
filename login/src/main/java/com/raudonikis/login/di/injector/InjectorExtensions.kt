package com.raudonikis.login.di.injector

import com.raudonikis.login.di.injector.LoginInjector.loginComponent
import com.raudonikis.login.ui.SignUpFragment
import com.raudonikis.login.ui.LoginFragment

fun LoginFragment.inject() {
    loginComponent.inject(this)
}

fun SignUpFragment.inject() {
    loginComponent.inject(this)
}