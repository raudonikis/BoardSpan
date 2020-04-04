package com.raudonikis.boardspan.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.raudonikis.boardspan.di.injector.inject
import com.raudonikis.core.R
import com.raudonikis.core.auth.AuthHandlerViewModel
import com.raudonikis.core.auth.AuthState
import com.raudonikis.core.di.ViewModelFactory
import javax.inject.Inject

class AuthHandlerFragment : Fragment(R.layout.fragment_auth_handler) {

    @Inject
    lateinit var authHandlerViewModelFactory: ViewModelFactory<AuthHandlerViewModel>
    private lateinit var authHandlerViewModel: AuthHandlerViewModel

    override fun onAttach(context: Context) {
        inject()
        authHandlerViewModel =
            ViewModelProvider(this, authHandlerViewModelFactory)[AuthHandlerViewModel::class.java]
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpObservers() {
        authHandlerViewModel.navigationEvent.observe(viewLifecycleOwner, Observer { authState ->
            when (authState) {
                AuthState.AUTHORIZED -> {
                    findNavController().navigate(AuthHandlerFragmentDirections.actionAuthHandlerFragmentToMainFragment())
                } //navigate to main screen
                AuthState.UNAUTHORIZED -> {
                    findNavController().navigate(AuthHandlerFragmentDirections.actionMainFragmentToNavGraphLogin())
                } //navigate to login screen
                else -> {
                } // do nothing
            }
        })
    }
}