package com.example.kind

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind.data.Charity
import com.example.kind.data.KindRepository
import com.example.kind.data.KindSource
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val kindSource: KindSource = KindSource()
    private val kindRepository: KindRepository = KindRepository()

    private val _charities = mutableStateOf(emptyList<Charity>())
    val charities: State<List<Charity>> = _charities

    private var _isSignedIn = mutableStateOf(false)
    val isSignedIn: State<Boolean> = _isSignedIn

    fun signIn() {
        _isSignedIn.value = true
        // TODO:
        // UI stuff here or?
    }

    suspend fun getUserData(){

    }

    fun trySignIn(email: String, password: String) = effect{
        val result = kindRepository.signIn(email, password)

        if(result.equals("SUCCESS")){
            signIn()
            getUserData()
        }
    }

    fun trySignUp(name: String, email: String, password: String) = effect{
        kindRepository.signUp(name, email, password)
    }

    fun signOut() {
        _isSignedIn.value = false
    }

    fun subscribeToCharity(charityId: Long) {
        val charity = getCharityById(charityId)
        charity?.let { kindRepository.subscribeToCharity(it) } //TODO idk if let is appropriate here
        println("subscribed to charity")
    }

    private fun getCharityById(charityId: Long): Charity? {
        return _charities.value.find { it.id == charityId }
    }

    fun signUp(data: List<String>) {
        //TODO data validation
        println(data)
    }

    fun load() = effect {
        _charities.value = kindRepository.allCharities()

        trySignIn("tester@gmail.com", "123456")
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }
}