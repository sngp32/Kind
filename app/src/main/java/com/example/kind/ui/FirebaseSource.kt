package com.example.kind.ui

class FirebaseSource {
    val AuthHandler = LoginActivity()

    fun userLogin(email: String, password: String){
        AuthHandler.signIn(email, password)
    }

    fun userSignup(email: String, password: String){
        AuthHandler.newSignup(email, password)
    }

}