package com.example.kind.data

data class KindModel(
    val name: String? = null,
    val email: String? = null,
    val charities: List<Charity>? = null,
    val isEmailNotificationEnabled: Boolean = false,
    val isPushNotificationEnabled: Boolean = false
)

data class Charity(
    val id: Long = -1,
    val name: String = "",
    val description: String = "",
    val isSubscribed: Boolean = false,
    val subscribeAmount: Int = 0
)
