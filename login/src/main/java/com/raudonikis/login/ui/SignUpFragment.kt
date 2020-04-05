package com.raudonikis.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raudonikis.login.R
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpListeners() {
        text_go_back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}