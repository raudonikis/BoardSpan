package com.raudonikis.login.di

import com.raudonikis.auth.di.modules.AuthModule
import com.raudonikis.login.ui.SignUpFragment
import com.raudonikis.login.ui.LoginFragment
import dagger.Component

@Component(modules = [AuthModule::class])
interface LoginComponent {

    @Component.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(target: LoginFragment)
    fun inject(target: SignUpFragment)
}