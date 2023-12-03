package com.gruvedrift.models

import kotlinx.serialization.Serializable

@Serializable
data class Customer (
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
)

val customerStorage = mutableListOf(
    Customer(
        "666",
        "David",
        "Goggins",
        "stay.hard@gmale.com"
    )
)
