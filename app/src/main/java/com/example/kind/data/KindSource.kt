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

    private fun addNewUserData(name: String, email: String) {
        val db = Firebase.firestore

        val userData = KindUserData(
            name,
            email,
            DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
        )

        db.collection("users").document(auth.currentUser!!.uid).set(userData)
    }

    suspend fun newSignup(name: String, email: String, password: String) {
        // TODO: Might change to require email verification before auto login

        auth.createUserWithEmailAndPassword(email, password)

        if (auth.currentUser != null) {
            sendEmailVerifification()
            addNewUserData(name, email)
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

    suspend fun getUserData(){

    }

    fun sendEmailVerifification() {
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email Verification sent
            }
    }

    companion object {
        private const val TAG = "KindFIRESTORE"
    }

}