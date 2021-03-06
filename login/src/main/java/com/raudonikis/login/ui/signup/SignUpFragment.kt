package com.raudonikis.login.ui.signup

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.raudonikis.core.di.ViewModelFactory
import com.raudonikis.core.extensions.clearErrorMessage
import com.raudonikis.core.extensions.getInput
import com.raudonikis.core.extensions.setOnDebouncedClickListener
import com.raudonikis.core.inputvalidation.ValidationResult
import com.raudonikis.login.R
import com.raudonikis.login.di.injector.inject
import kotlinx.android.synthetic.main.fragment_sign_up.*
import javax.inject.Inject

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    @Inject
    lateinit var signUpViewModelFactory: ViewModelFactory<SignUpViewModel>
    private lateinit var signUpViewModel: SignUpViewModel

    override fun onAttach(context: Context) {
        inject()
        signUpViewModel = ViewModelProvider(this, signUpViewModelFactory)[SignUpViewModel::class.java]
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpListeners()
        setUpObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpObservers() {
        signUpViewModel.signUpEvent.observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                true -> {
                    Snackbar.make(root_sign_up, "Account created successfully", Snackbar.LENGTH_LONG).show()
                    findNavController().popBackStack()
                }
                false -> Snackbar.make(root_sign_up, "Failed to create an account", Snackbar.LENGTH_LONG).show()
            }
        })
        signUpViewModel.emailValidator.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                ValidationResult.EMPTY -> text_input_email.error = getString(R.string.error_email_empty)
                ValidationResult.INVALID -> text_input_email.error =
                    getString(R.string.error_email_invalid)
                ValidationResult.VALID -> text_input_email.clearErrorMessage()
                else -> {}
            }
        })
        signUpViewModel.passwordValidator.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                ValidationResult.EMPTY -> text_input_password.error = getString(R.string.error_password_empty)
                ValidationResult.PASSWORDS_NOT_MATCHING -> text_input_password.error = getString(R.string.error_password_match)
                ValidationResult.VALID -> text_input_password.clearErrorMessage()
                else -> {}
            }
        })
        signUpViewModel.passwordConfirmValidator.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                ValidationResult.EMPTY -> text_input_password_confirm.error = getString(R.string.error_password_empty)
                ValidationResult.PASSWORDS_NOT_MATCHING -> text_input_password_confirm.error = getString(R.string.error_password_match)
                ValidationResult.VALID -> text_input_password_confirm.clearErrorMessage()
                else -> {}
            }
        })
    }

    private fun setUpListeners() {
        text_go_back.setOnClickListener {
            findNavController().popBackStack()
        }
        button_create_account.setOnDebouncedClickListener {
            signUpViewModel.signIn(getEmailInput(), getPasswordInput(), getConfirmPasswordInput())
        }
    }

    private fun getEmailInput(): String {
        return text_input_email.getInput()
    }

    private fun getPasswordInput(): String {
        return text_input_password.getInput()
    }

    private fun getConfirmPasswordInput(): String {
        return text_input_password_confirm.getInput()
    }
}