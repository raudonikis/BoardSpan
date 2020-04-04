package com.raudonikis.boardspan.navigation

import com.raudonikis.auth.ui.AuthHandlerFragmentDirections

object AppRouter {
    val authHandlerToMain = AuthHandlerFragmentDirections.actionAuthHandlerFragmentToMainFragment()
    val authHandlerToLogin = AuthHandlerFragmentDirections.actionMainFragmentToNavGraphLogin()
}