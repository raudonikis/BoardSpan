package com.raudonikis.auth.di

import com.raudonikis.auth.di.modules.AuthModule
import com.raudonikis.auth.ui.AuthHandlerFragment
import dagger.Component

@Component(modules = [AuthModule::class])
interface AuthComponent {

    @Component.Factory
    interface Factory {
        fun create(): AuthComponent
    }

    fun inject(target: AuthHandlerFragment)
}