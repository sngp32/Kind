package com.example.kind.data

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
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

        return@withContext charityData
    }

    suspend private fun addNewUserData(name: String, email: String) {
        val userData = KindUserData(
            name,
            email,
            DateTimeFormatter.ISO_INSTANT.format(Instant.now()),
        )

        val user = auth.currentUser
        if(user != null){
            db.collection("users").document(user.uid).set(userData)
        }
    }

    suspend fun newSignup(name: String, email: String, password: String) {
        // TODO: Might change to require email verification before auto login

        if(auth.currentUser != null){
            // Cant create new account because user is already logged in.
        }
        else{
            auth.createUserWithEmailAndPassword(email, password).await()

            if (auth.currentUser != null) {
                sendEmailVerifification()
                addNewUserData(name, email)
            }
        }
    }

    suspend fun persistenceLoginCheck(): Boolean {
        if(auth.currentUser != null){
            return true
        }
        else{
            return false
        }
    }

    suspend fun signIn(email: String, password: String): String {
        auth.signInWithEmailAndPassword(email, password)

        if (auth.currentUser != null) {
            return "SUCCESS"
        } else {
            return "LOGINFAILED"
        }
    }

    suspend fun getUserData(): KindUserData {
        val user = auth.currentUser

        if (user != null) {
            val data = db.collection("users").document(user.uid).get().await()

            Log.d(TAG, "${data.id} => ${data.data}")

            val userData = KindUserData(
                data["name"].toString(),
                data["email"].toString(),
                data["registrationDate"].toString(),
                data["subbedCharities"] as List<Charity>?,
                data["totalDonated"] as Long,
                data["areEmailNotificationEnabled"] as Boolean,
                data["arePushNotificationEnabled"] as Boolean
            )

            return userData
        }
        else{
            return KindUserData()
        }
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