package com.raudonikis.auth.di.injector

import com.raudonikis.auth.di.AuthComponent
import com.raudonikis.auth.di.DaggerAuthComponent

object AuthInjector {

    val authComponent: AuthComponent by lazy {
        DaggerAuthComponent.create()
    }
}