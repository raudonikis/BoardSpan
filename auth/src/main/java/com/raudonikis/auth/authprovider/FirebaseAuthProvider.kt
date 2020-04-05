package com.raudonikis.auth.authprovider

import com.google.firebase.auth.FirebaseAuth
import com.raudonikis.auth.extensions.toUserAccount
import com.raudonikis.auth.model.UserAccount
import javax.inject.Inject

class FirebaseAuthProvider @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthProvider {

    override fun signInWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                when {
                    task.isSuccessful -> {
                        onSuccess()
                    }
                    else -> {
                        onFailure()
                    }
                }
            }
    }

    override fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                when {
                    task.isSuccessful -> {
                        onSuccess()
                    }
                    else -> {
                        onFailure()
                    }
                }
            }
    }

    override fun getUserAccount(): UserAccount? {
        return firebaseAuth.currentUser?.toUserAccount()
    }


    override fun isUserSignedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }
}