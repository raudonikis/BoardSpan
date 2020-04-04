package com.raudonikis.boardspan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raudonikis.auth.enums.AuthState
import com.raudonikis.auth.ui.AuthHandlerViewModel
import com.raudonikis.boardspan.di.injector.inject
import com.raudonikis.boardspan.navigation.AppRouter
import com.raudonikis.core.di.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var navController: NavController

    @Inject
    lateinit var authHandlerViewModelFactory: ViewModelFactory<AuthHandlerViewModel>
    private lateinit var authHandlerViewModel: AuthHandlerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        inject()
        authHandlerViewModel =
            ViewModelProvider(this, authHandlerViewModelFactory)[AuthHandlerViewModel::class.java]
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setUpObservers()
    }

    private fun setUpObservers() {
        authHandlerViewModel.authenticationEvent.observe(this, Observer { authState ->
            when (authState) {
                AuthState.AUTHORIZED -> {
                    navController.navigate(AppRouter.authHandlerToMain)
                } //navigate to main screen
                AuthState.UNAUTHORIZED -> {
                    navController.navigate(AppRouter.authHandlerToLogin)
                } //navigate to login screen
                else -> {
                } // do nothing
            }
        })
    }

    override fun onBackPressed() {
        when (navController.currentDestination?.id) {
            R.id.loginFragment, R.id.mainFragment -> finish()
            else -> super.onBackPressed()
        }
    }
}
