package com.example.kind.data

import com.google.firebase.auth.FirebaseUser


class KindRepository(
    private val kindSource: KindSource = KindSource(),
) {
    suspend fun allCharities(): List<Charity> = kindSource.loadCharities()

    fun subscribeToCharity(charity: Charity) {
        //should request source to subscribe to charity
    }

    suspend fun signIn(email: String, password: String): String { return kindSource.signIn(email, password)}

    suspend fun signUp(name: String, email: String, password: String) { return kindSource.newSignup(name, email, password)}
}
