package com.raudonikis.login.di.injector

import com.raudonikis.login.di.DaggerLoginComponent
import com.raudonikis.login.di.LoginComponent

object LoginInjector {

    val loginComponent: LoginComponent by lazy {
        DaggerLoginComponent.create()
    }
}