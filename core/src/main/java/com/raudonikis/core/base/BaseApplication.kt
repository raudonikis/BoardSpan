package com.raudonikis.core.base

import android.app.Application
import com.raudonikis.core.BuildConfig
import com.raudonikis.core.di.components.CoreComponent
import com.raudonikis.core.di.components.DaggerCoreComponent
import timber.log.Timber
import timber.log.Timber.DebugTree


class BaseApplication : Application() {

    val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    companion object {
        lateinit var instance: BaseApplication
            private set
    }
}