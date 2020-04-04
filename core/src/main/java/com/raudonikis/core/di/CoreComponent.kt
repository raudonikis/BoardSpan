package com.raudonikis.core.di

import android.app.Application
import com.raudonikis.core.di.modules.AuthModule
import com.raudonikis.core.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AuthModule::class])
@AppScope
interface CoreComponent {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): CoreComponent
    }
}