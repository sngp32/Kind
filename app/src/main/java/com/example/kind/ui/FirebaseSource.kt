package com.example.kind.ui

class FirebaseSource {
    val AuthHandler = LoginActivity()

    fun userLogin(email: String, password: String){
        AuthHandler.signIn("BigChunk@gmail.com", "1234567890")
    }

    fun userSignup(email: String, password: String){
        AuthHandler.newSignup("BigChunk3@gmail.com", "1234567890")
    }

}