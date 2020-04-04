package com.raudonikis.auth.di.modules

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object AuthModule {

    @Provides
    @Reusable
    fun provideAuthInstance() = FirebaseAuth.getInstance()
}