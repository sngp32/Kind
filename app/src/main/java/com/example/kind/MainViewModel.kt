package com.example.kind

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind.data.Charity
import com.example.kind.data.KindRepository
import com.example.kind.data.KindUserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val kindRepository: KindRepository = KindRepository()

    private val _charities = mutableStateOf(emptyList<Charity>())
    val charities: State<List<Charity>> = _charities

    private var _isSignedIn = mutableStateOf(false)
    val isSignedIn: State<Boolean> = _isSignedIn

    private var _userData = mutableStateOf(KindUserData())
    val userData: State<KindUserData> = _userData

    fun signIn() {
        _isSignedIn.value = true
        // TODO:
        // UI stuff here or?
    }

    suspend fun getUserData(){
        _userData = mutableStateOf(kindRepository.getUserData())
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

    fun persistenceLogin() = effect{
        if(kindRepository.persistenceLoginCheck()){
            signIn()
            getUserData()
        }
    }

    fun load() = effect {
        persistenceLogin()

        // TODO: Don't load before user is logged in. It needs a valid auth
        _charities.value = kindRepository.allCharities()


        //trySignUp("Pissed","testerboy17@gmail.com", "123456")
        //trySignIn("testerboy16@gmail.com", "123456")
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }
}