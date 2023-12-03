package com.gruvedrift.routes

import com.gruvedrift.models.Customer
import com.gruvedrift.models.customerStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound )
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val customer = customerStorage.find { it.id == id } ?: return@get call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
            call.respond(customer)
        }
        post {
            val newCustomer = call.receive<Customer>()
            customerStorage.add(newCustomer)
            call.respondText(
                "Customer stored successfully",
                status =  HttpStatusCode.Created
            )
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                "Missing Id",
                status = HttpStatusCode.BadRequest
            )
            if (customerStorage.remove(customerStorage.find { it.id == id })){
                call.respondText(
                    "Customer removed correctly",
                    status = HttpStatusCode.Accepted
                )
            } else {
                call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            }
        }
    }
}
