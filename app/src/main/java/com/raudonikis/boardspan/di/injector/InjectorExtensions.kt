package com.raudonikis.boardspan.di.injector

import com.raudonikis.boardspan.MainActivity
import com.raudonikis.boardspan.di.injector.AppInjector.appComponent

fun MainActivity.inject() {
    appComponent.inject(this)
}