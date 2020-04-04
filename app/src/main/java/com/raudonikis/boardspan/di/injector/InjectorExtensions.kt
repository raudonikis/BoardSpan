package com.raudonikis.boardspan.di.injector

import com.raudonikis.boardspan.di.injector.AppInjector.appComponent
import com.raudonikis.boardspan.ui.AuthHandlerFragment

fun AuthHandlerFragment.inject() {
    appComponent.inject(this)
}