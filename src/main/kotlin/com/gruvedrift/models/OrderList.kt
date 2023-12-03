package com.gruvedrift.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val orderId: String,
    val orders: List<OrderItem>
)

@Serializable
data class OrderItem(
    val item: String,
    val price: Double,
    val amount: Int,
)

val orderStorage = listOf(
    Order(
        orderId = "1",
        orders = listOf(
            OrderItem(
                item = "Phone",
                price = 499.99,
                amount = 1,
            ),
            OrderItem(
                item = "Headset",
                price = 149.00,
                amount = 2,
            ),
            OrderItem(
                item = "Bread",
                price = 0.99,
                amount = 4,
            ),
            OrderItem(
                item = "Apple",
                price = 0.40,
                amount = 100,
            ),
        )
    ),
    Order(
        orderId = "2",
        orders = listOf(
            OrderItem(
                item = "Ski",
                price = 299.98,
                amount = 2,
            ),
            OrderItem(
                item = "Mouse",
                price = 99.00,
                amount = 1,
            ),
            OrderItem(
                item = "Juice",
                price = 0.79,
                amount = 5,
            ),
            OrderItem(
                item = "Orange",
                price = 0.60,
                amount = 250,
            ),
        )
    ),
)
