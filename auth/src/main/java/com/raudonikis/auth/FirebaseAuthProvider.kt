package com.raudonikis.auth

import com.google.firebase.auth.FirebaseAuth
import com.raudonikis.auth.model.UserAccount
import javax.inject.Inject

class FirebaseAuthProvider @Inject constructor(private val firebaseAuth: FirebaseAuth) : AuthProvider{

    override fun signInWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                when {
                    task.isSuccessful -> {
                        // Success
                    }
                    else -> {
                        // Fail
                    }
                }
            }
    }

    override fun signUpWithEmailAndPassword(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                when {
                    task.isSuccessful -> {
                        // Success
                    }
                    else -> {
                        // Fail
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