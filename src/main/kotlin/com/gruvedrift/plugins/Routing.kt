package com.gruvedrift.plugins

import com.gruvedrift.routes.customerRouting
import com.gruvedrift.routes.orderListRoute
import com.gruvedrift.routes.orderRoute
import com.gruvedrift.routes.orderTotal
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        orderListRoute()
        orderRoute()
        orderTotal()
    }
}
