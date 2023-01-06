package com.example.kind

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind.data.Charity
import com.example.kind.data.KindRepository
import com.example.kind.data.KindSource
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

    fun subscribeToCharity(charityId: Long) {
        val charity = getCharityById(charityId)
        charity?.let { kindRepository.subscribeToCharity(it) } //TODO idk if let is appropriate here
        println("subscribed to charity")
    }

    private fun getCharityById(charityId: Long): Charity? {
        return _charities.value.find { it.id == charityId }
    }

    fun load() = effect {
        _charities.value = kindRepository.allCharities()
    }

    private fun effect(block: suspend () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { block() }
    }
}