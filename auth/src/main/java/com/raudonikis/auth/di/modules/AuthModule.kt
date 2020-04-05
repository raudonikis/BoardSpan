package com.raudonikis.auth.di.modules

import com.google.firebase.auth.FirebaseAuth
import com.raudonikis.auth.authprovider.AuthProvider
import com.raudonikis.auth.authprovider.FirebaseAuthProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [AuthModule.AuthModuleInner::class])
abstract class AuthModule {

    @Binds
    @Reusable
    abstract fun provideAuthProvider(firebaseAuthProvider: FirebaseAuthProvider): AuthProvider

    @Module
    object AuthModuleInner {
        @Provides
        @Reusable
        fun provideFirebaseAuthInstance() = FirebaseAuth.getInstance()
    }
}