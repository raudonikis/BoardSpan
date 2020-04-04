package com.raudonikis.auth.di.injector

import com.raudonikis.auth.ui.AuthHandlerFragment
import com.raudonikis.auth.di.injector.AuthInjector.authComponent

fun AuthHandlerFragment.inject() {
    authComponent.inject(this)
}