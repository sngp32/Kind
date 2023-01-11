package com.example.kind.data

data class KindUserData(
    val name: String = "Invalid Account",
    val email: String = "",
    val registrationDate: String? = null,
    val subbedCharities: List<userCharityData>? = null,
    val totalDonated: Long = 0,
    val areEmailNotificationEnabled: Boolean = true,
    val arePushNotificationEnabled: Boolean = true,
)

data class Charity(
    val id: Long = -1,
    val name: String = "",
    val description: String = "",
    val isSubscribed: Boolean = false,
    val subscribeAmount: Long = 0,
    val readMore: String = ""
)

data class userCharityData(
    val id: Long = -1,
    val isSubscribed: Boolean = false,
    val subscriptionAmount: Long = 0,
    val subscribedSince: String? = ""
)

data class News(
    val id: Long = -1,
    val headline: String = "",
    val description: String = "",
    val date: String = "",
)
