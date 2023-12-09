package com.gruvedrift

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ApplicationTest {
    @Test
    fun getOrderTotal() = testApplication {
        val response = client.get("/order/1/total")
        assertEquals(
            """841.95""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun getCustomer() = testApplication {
        val response = client.get("/customer")
        assertEquals(
            """[{"id":"666","firstName":"David","lastName":"Goggins","email":"stay.hard@gmale.com"}]""" ,
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }
}
