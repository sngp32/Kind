package com.example.kind.data

data class KindUserData(
    val name: String? = null,
    val email: String? = null,
    val registrationDate: String? = null,
    val subbedCharities: List<Charity>? = null,
    val totalDonated: Int = 0,
    val areEmailNotificationEnabled: Boolean = true,
    val arePushNotificationEnabled: Boolean = true,
)

data class Charity(
    val id: Long = -1,
    val name: String = "",
    val description: String = "",
    val isSubscribed: Boolean = false,
    val subscribeAmount: Int = 0
)
