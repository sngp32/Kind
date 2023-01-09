package com.example.kind.data

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.traceEventStart
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.io.IOException
import java.nio.file.WatchEvent.Kind
import java.time.Instant
import java.time.format.DateTimeFormatter

class KindSource(
    private val auth: FirebaseAuth = firebaseAuth,
    private val db: FirebaseFirestore = firebaseDB
) : Activity() {

    private lateinit var charityData: MutableList<Charity>

    suspend fun loadCharities(): MutableList<Charity> = withContext(Dispatchers.IO) {
        charityData = mutableListOf()

        val data = db.collection("CharityTypes").get().await()

        for (document in data) {
            val newCharity = Charity(
                document.id.toLong(),
                document.data["Name"].toString(),
                document.data["Description"].toString()
            )
            charityData.add(newCharity)
            Log.d(TAG, "${document.id} => ${document.data}")
        }


                /*

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

                 */


        // TODO:
        // This returns nothing because above function is asynchronous
        return@withContext charityData
    }


    data class newUserData(
        val name: String? = null,
        val email: String? = null,
        val registrationDate: String? = null,
        val subbedCharities: List<String>? = null,
        val totalDonations: Int? = null
    )

    private fun addNewUserData(email: String, user: FirebaseUser) {
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

    suspend fun newSignup(email: String, password: String) {
        print("wtf")
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    if (user != null) {
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

    suspend fun signIn(email: String, password: String): String {
        auth.signInWithEmailAndPassword(email, password)

        if(auth.currentUser != null){
            return "SUCCESS"
        }
        else{
            return "LOGINFAILED"
        }
    }

    fun sendEmailVerifification() {
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
    }

    fun updateUI(user: FirebaseUser?) {

    }

    companion object {
        private const val TAG = "KindFIRESTORE"
    }

}