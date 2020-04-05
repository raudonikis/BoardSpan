package com.raudonikis.login.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raudonikis.core.di.ViewModelFactory
import com.raudonikis.core.extensions.clearErrorMessage
import com.raudonikis.core.extensions.getInput
import com.raudonikis.core.extensions.navigate
import com.raudonikis.core.extensions.setOnDebouncedClickListener
import com.raudonikis.core.inputvalidation.ValidationResult
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
            when (loginSuccessful) {
                true -> {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }
                false -> {
                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show()
                }
            }
        })
        loginViewModel.emailValidator.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                ValidationResult.EMPTY -> text_input_email.error = getString(R.string.error_email_empty)
                ValidationResult.INVALID -> text_input_email.error =
                    getString(R.string.error_email_invalid)
                else -> text_input_email.clearErrorMessage()
            }
        })
        loginViewModel.passwordValidator.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                ValidationResult.EMPTY -> text_input_password.error = getString(R.string.error_password_empty)
                else -> text_input_password.clearErrorMessage()
            }
        })
    }

    private fun setUpListeners() {
        text_sign_up.setOnClickListener {
            text_input_email.clearErrorMessage()
            text_input_password.clearErrorMessage()
            navigate(LoginRouter.loginToSignUp)
        }
        button_login.setOnDebouncedClickListener {
            loginViewModel.signIn(getEmailInput(), getPasswordInput())
        }
    }

    private fun getEmailInput(): String {
        return text_input_email.getInput()
    }

    private fun getPasswordInput(): String {
        return text_input_password.getInput()
    }
}