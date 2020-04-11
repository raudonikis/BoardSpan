package com.raudonikis.boardspan.di.injector

import com.raudonikis.boardspan.di.AppComponent
import com.raudonikis.boardspan.di.DaggerAppComponent

object AppInjector {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}