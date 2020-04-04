package com.raudonikis.boardspan.di.components

import com.raudonikis.boardspan.ui.AuthHandlerFragment
import com.raudonikis.core.di.components.CoreComponent
import com.raudonikis.core.di.scopes.FeatureScope
import dagger.Component

@Component(dependencies = [CoreComponent::class])
@FeatureScope
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(target: AuthHandlerFragment)
}