package com.raudonikis.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.raudonikis.core.extensions.navigate
import com.raudonikis.login.R
import com.raudonikis.login.navigation.LoginRouter
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpListeners() {
        text_sign_up.setOnClickListener {
            navigate(LoginRouter.loginToSignUp)
        }
    }
}