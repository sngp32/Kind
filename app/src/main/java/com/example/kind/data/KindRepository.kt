package com.example.kind.data

import com.google.firebase.auth.FirebaseUser


class KindRepository(
    private val kindSource: KindSource = KindSource(),
) {
    suspend fun allCharities(): List<Charity> = kindSource.loadCharities()

    fun subscribeToCharity(charity: Charity) {
        //should request source to subscribe to charity
    }

    suspend fun signIn(email: String, password: String): String = kindSource.signIn(email, password)

    suspend fun signUp(name: String, email: String, password: String) = kindSource.newSignup(name, email, password)

    suspend fun getUserData(): KindUserData = kindSource.getUserData()

    suspend fun persistenceLoginCheck(): Boolean = kindSource.persistenceLoginCheck()

    suspend fun allNews(): List<News> = kindSource.loadNews()

}
