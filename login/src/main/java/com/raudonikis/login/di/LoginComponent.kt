package com.raudonikis.login.di

import com.raudonikis.auth.di.modules.AuthModule
import com.raudonikis.login.ui.signup.SignUpFragment
import com.raudonikis.login.ui.login.LoginFragment
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