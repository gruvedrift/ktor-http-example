package com.gruvedrift.routes

import com.gruvedrift.models.orderStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.orderListRoute() {
   route("/orderList"){
       get {
           if (orderStorage.isNotEmpty()) {
               call.respond(orderStorage)
           } else {
               call.respondText("No orders found", status = HttpStatusCode.NotFound)
           }
       }
   }
}

fun Route.orderRoute() {
    route("/order") {
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText("Bad request", status = HttpStatusCode.BadRequest)
            val order = orderStorage.find { it.orderId == id } ?: return@get call.respondText("No order with id $id", status = HttpStatusCode.NotFound)
            call.respond(order)
        }
    }
}

fun Route.orderTotal() {
    get ("/order/{id?}/total"){
        val id = call.parameters["id"] ?: return@get call.respondText("Bad request, no id provided", status = HttpStatusCode.BadRequest)
        val order = orderStorage.find { it.orderId == id } ?: return@get call.respondText("No order with id $id found", status = HttpStatusCode.NotFound)
        call.respond( order.orders.sumOf { it.amount * it.price })
    }
}
