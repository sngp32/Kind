package com.example.kind.data


class KindRepository(
    private val kindSource: KindSource = KindSource(),
    private var firebaseClient: KindFirebaseClient = KindFirebaseClient()
) {
    fun allCharities(): List<Charity> = firebaseClient.loadCharities()

    fun subscribeToCharity(charity: Charity) {
        //should request source to subscribe to charity
    }
}
