package com.raudonikis.boardspan.di

import com.raudonikis.auth.di.modules.AuthModule
import com.raudonikis.boardspan.ui.MainActivity
import com.raudonikis.core.di.scopes.FeatureScope
import dagger.Component

@Component(modules = [AuthModule::class])
@FeatureScope
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(): AppComponent
    }

    fun inject(target: MainActivity)
}