package com.example.kind.data

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
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

    suspend fun loadNews(): MutableList<News> {
        val newsData: MutableList<News> = mutableListOf()
        val data = db.collection("news").get().await()

        for (document in data) {
            val newsItem = News(
                document.id.toLong(),
                document.data["Headline"].toString(),
                document.data["Description"].toString(),
                document.data["date"].toString()
            )
            newsData.add(newsItem)
            Log.d(TAG, "${document.id} => ${document.data}")
        }

        return newsData
    }

    suspend fun logout(){
        auth.signOut()
    }

    suspend fun subscribeToCharity(charityID: Long, subscriptionAmount: Long): KindUserData {
        val user = auth.currentUser

        if(user != null){
            var data = db.collection("users").document(user.uid).get().await()

            var time = DateTimeFormatter.ISO_INSTANT.format(Instant.now())

            if(data["subbedCharities"] != null){
                val subbedCharityData = data["subbedCharities"] as ArrayList<*>
                for(charity in subbedCharityData){
                    val charityHashMap = charity as HashMap<*, *>

                    if(charityHashMap["id"] == charityID) {
                        time = charityHashMap["subscribedSince"] as String?

                        db.collection("users").document(user.uid).update("subbedCharities", FieldValue.arrayRemove(
                            userCharityData(
                                charityHashMap["id"] as Long,
                                charityHashMap["subscribed"] as Boolean,
                                charityHashMap["subscriptionAmount"] as Long,
                                charityHashMap["subscribedSince"] as String?
                            ))
                        ).await()
                    }
                }
            }

            db.collection("users").document(user.uid).update("subbedCharities", FieldValue.arrayUnion(
                userCharityData(
                    charityID,
                    true,
                    subscriptionAmount,
                    time
                ))
            ).await()
            }

        return getUserData()
    }

    suspend fun loadCharities(): MutableList<Charity> = withContext(Dispatchers.IO) {
        val charityData: MutableList<Charity> = mutableListOf()

        val data = db.collection("CharityTypes").get().await()

        for (document in data) {
            val newCharity = Charity(
                id = document.id.toLong(),
                name = document.data["Name"].toString(),
                description = document.data["Description"].toString(),
                readMore = document.data["ReadMore"].toString()
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
                data["subbedCharities"] as List<userCharityData>?,
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

