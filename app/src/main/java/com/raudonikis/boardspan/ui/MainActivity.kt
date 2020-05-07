package com.raudonikis.boardspan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raudonikis.boardspan.R
import com.raudonikis.boardspan.di.injector.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var navController: NavController

    /*@Inject
    lateinit var authHandlerViewModelFactory: ViewModelFactory<AuthHandlerViewModel>
    private val authHandlerViewModel: AuthHandlerViewModel by viewModels { authHandlerViewModelFactory }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        inject()
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        setUpObservers()
    }

    /*private fun setUpObservers() {
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
    }*/

    /* override fun onBackPressed() {
         when (navController.currentDestination?.id) {
             R.id.loginFragment, R.id.mainFragment -> finish()
             else -> super.onBackPressed()
         }
     }*/
}
