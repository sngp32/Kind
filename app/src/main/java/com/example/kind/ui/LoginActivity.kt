package com.example.kind.ui

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LoginActivity : Activity() {
    private lateinit var auth: FirebaseAuth

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // TODO
            // If user is logged in, update state or something
        }
    }

    data class newUserData(
        val email: String? = null,
        val registrationDate: String? = null,
        val subbedCharities: List<String>? = null,
        val totalDonations: Int? = null
    )


    private fun addNewUserData(email: String, user: FirebaseUser){
        auth = Firebase.auth
        val db = Firebase.firestore

        val userData = newUserData(
            email,
            DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
            null,
            0
        )

        db.collection("users").document(user.uid).set(userData)
    }

    fun newSignup(email: String, password: String) {
        auth = Firebase.auth
        print("wtf")
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    if(user != null){
                        addNewUserData(email, user)
                    }

                    // Update UI State
                    // updateUI(user)
                } else {
                    /*
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                     */

                    // Update UI State
                    // updateUI(null)
                }
            }
    }

    fun signIn(email: String, password: String) {
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser

                    // Update UI State
                    // updateUI(user)
                } else {
                    /*
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()

                     */

                    // Update UI State
                    // updateUI(null)
                }
            }
    }

    fun sendEmailVerifification(){
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
    }

    fun updateUI(user: FirebaseUser?){

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}