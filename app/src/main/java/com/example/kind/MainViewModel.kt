package com.example.kind

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind.data.Charity
import com.example.kind.data.KindRepository
import com.example.kind.data.KindUserData
import com.example.kind.data.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val kindRepository: KindRepository = KindRepository()

    private val _charities = mutableStateOf(emptyList<Charity>())
    val charities: State<List<Charity>> = _charities

    private val _news = mutableStateOf(emptyList<News>())
    val news: State<List<News>> = _news

    private var _isSignedIn = mutableStateOf(false)
    val isSignedIn: State<Boolean> = _isSignedIn

    private var _isIncorrectLogin = mutableStateOf(false)
    val isIncorrectLogin: State<Boolean> = _isIncorrectLogin

    private var _userData = mutableStateOf(KindUserData())
    val userData: State<KindUserData> = _userData

    private var _userTotalSub = mutableStateOf(0.toLong())
    val userTotalSub: State<Long> = _userTotalSub

    fun signIn() {
        _isSignedIn.value = true
        // TODO: UI stuff here or?
    }

    suspend fun getUserData() {
        _userData.value = kindRepository.getUserData()

        _charities.value = kindRepository.allCharities()
        _news.value = kindRepository.allNews()

        _userTotalSub.value = calcUserTotalSub()
    }

    fun calcUserTotalSub(): Long {
        val userData = _userData.value
        var total: Long = 0

        if (userData.subbedCharities != null) {
            val subbedCharities = userData.subbedCharities as ArrayList<HashMap<*, *>>

            if (subbedCharities != null) {
                for (charityHashMap in subbedCharities) {

                    val subscriptionAmount = charityHashMap["subscriptionAmount"] as Long
                    if (subscriptionAmount != null) {
                        total += subscriptionAmount
                    }

                }
            }
        }

        return total
    }

    fun trySignIn(signInData: List<String>) = effect {
        val result = kindRepository.signIn(signInData[0], signInData[1])

        if (result.equals("SUCCESS")) {
            signIn()
            getUserData()
        }
    }

    fun trySignUp(signUpData: List<String>) = effect {
        kindRepository.signUp(signUpData[0], signUpData[1], signUpData[2])
    }

    fun signOut() {
        _isSignedIn.value = false
    }

    fun subscribeToCharity(charityID: Long, subscriptionAmount: Long) = effect {
        kindRepository.subscribeToCharity(charityID, subscriptionAmount)
        println("subscribed to charity")
    }

    private fun getCharityById(charityId: Long): Charity? {
        return _charities.value.find { it.id == charityId }
    }

    fun authLogout() = effect {
        kindRepository.logout()
        signOut()
    }

    fun signUp(data: List<String>) {
        //TODO data validation
        println(data)
    }

    fun persistenceLogin() = effect {
        if (kindRepository.persistenceLoginCheck()) {
            signIn()
            getUserData()
        }
    }

    fun load() = effect {
        persistenceLogin()
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }
}