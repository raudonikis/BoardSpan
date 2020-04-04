package com.raudonikis.boardspan.di.injector

import com.raudonikis.boardspan.di.components.AppComponent
import com.raudonikis.boardspan.di.components.DaggerAppComponent
import com.raudonikis.core.base.BaseApplication

object AppInjector {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            BaseApplication.instance.coreComponent
        )
    }
}