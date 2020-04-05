package com.raudonikis.login.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raudonikis.core.di.ViewModelFactory
import com.raudonikis.core.extensions.navigate
import com.raudonikis.login.R
import com.raudonikis.login.di.injector.inject
import com.raudonikis.login.navigation.LoginRouter
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory<LoginViewModel>
    private lateinit var loginViewModel: LoginViewModel

    override fun onAttach(context: Context) {
        inject()
        loginViewModel = ViewModelProvider(this, loginViewModelFactory)[LoginViewModel::class.java]
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpListeners()
        setUpObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpObservers() {
        loginViewModel.loginEvent.observe(viewLifecycleOwner, Observer { loginSuccessful ->
            when(loginSuccessful) {
                true -> { Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show() }
                false -> { Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show() }
            }
        })
    }

    private fun setUpListeners() {
        text_sign_up.setOnClickListener {
            navigate(LoginRouter.loginToSignUp)
        }
        button_login.setOnClickListener {
            val email = text_input_email.editText?.text.toString()
            val password = text_input_password.editText?.text.toString()
            loginViewModel.signIn(email, password)
        }
    }
}