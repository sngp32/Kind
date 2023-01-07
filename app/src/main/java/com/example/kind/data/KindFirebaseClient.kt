package com.example.kind.data

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.Instant
import java.time.format.DateTimeFormatter


//TODO create connection to firebase

class KindFirebaseClient(
    private var auth: FirebaseAuth = Firebase.auth,
    private val db: FirebaseFirestore = Firebase.firestore
) : Activity(){

    fun loadCharities(): MutableList<Charity> {
        println("KEVINPRINTED")

        val charityData: MutableList<Charity> = mutableListOf()

        db.collection("CharityTypes").get()
        .addOnSuccessListener { documents ->
            for (document in documents) {
                val newCharity = Charity(
                    document.id.toLong(),
                    document.data["Name"].toString(),
                    document.data["Description"].toString()
                )
                charityData.add(newCharity)
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }.addOnFailureListener { exception ->
                Log.w(TAG, "Error getting charity types: ", exception)
        }

        // TODO:
        // This returns nothing because above fucntion is asynchronous
        return charityData
    }


    data class newUserData(
        val name: String? = null,
        val email: String? = null,
        val registrationDate: String? = null,
        val subbedCharities: List<String>? = null,
        val totalDonations: Int? = null
    )

    private fun addNewUserData(email: String, user: FirebaseUser){
        auth = Firebase.auth
        val db = Firebase.firestore

        val userData = newUserData(
            "TEST",
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
                    // Debug message
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    /*
                    // Add ui fail

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

                    // Debug message
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    /*
                    // Add ui fail
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
        private const val TAG = "KindFIRESTORE"
    }



}