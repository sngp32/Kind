package com.example.kind.data


class KindRepository(
    private val kindSource: KindSource = KindSource(),
) {
    suspend fun allCharities(): List<Charity> = kindSource.loadCharities()

    fun subscribeToCharity(charity: Charity) {
        //should request source to subscribe to charity
    }
}
