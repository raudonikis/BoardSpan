package com.raudonikis.boardspan.di.injector

import com.raudonikis.boardspan.di.components.AppComponent
import com.raudonikis.boardspan.di.components.DaggerAppComponent

object AppInjector {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}