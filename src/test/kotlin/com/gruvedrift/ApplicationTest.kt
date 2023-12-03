package com.gruvedrift

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ApplicationTest {

    @Test
    fun testGetCustomer() = withTestApplication(Application::module) {
        val response = handleRequest(HttpMethod.Get, "/customer").response
        assertEquals(
            """[{"id":"666","firstName":"David","lastName":"Goggins","email":"stay.hard@gmale.com"}]"""
            , response.content
        )
        assertEquals(
            HttpStatusCode.OK, response.status()
        )
    }
}
