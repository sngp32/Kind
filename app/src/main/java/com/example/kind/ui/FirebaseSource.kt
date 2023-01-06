package com.example.kind.ui

class FirebaseSource {
    val AuthHandler = LoginActivity()

    fun userLogin(){
        AuthHandler.signIn("BigChunk@gmail.com", "1234567890")
    }

    fun userSignup(){
        AuthHandler.newSignup("BigChunk2@gmail.com", "1234567890")
    }

}