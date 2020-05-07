package com.raudonikis.boardspan.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raudonikis.auth.AuthHandler
import com.raudonikis.boardspan.R
import com.raudonikis.boardspan.di.injector.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    @Inject
    lateinit var authHandler: AuthHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        inject()
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setUpDestinationChangeListener()
    }

    private fun setUpDestinationChangeListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when {
                destination.parent?.id != R.id.nav_graph_login -> {
                    if(!authHandler.isUserSignedIn()) navController.navigate(R.id.actionToLoginGraph)
                }
            }
        }
    }
}
