package com.example.kind.data

class KindSource() {
    fun loadCharities(): List<Charity> { //TODO temporary charities, should be fetched from firebase
        return listOf(
            Charity(1, "Charity1", "Description1"),
            Charity(2, "Charity2", "Description2")
        )
    }
}