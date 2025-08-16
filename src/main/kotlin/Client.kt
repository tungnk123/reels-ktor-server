package com.tungnk123

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import kotlinx.serialization.json.Json

object Clients {
    private val sessionId = System.getenv("IG_SESSION_ID") ?: ""
    private val appId = System.getenv("IG_APP_ID") ?: "567067343352427"
    private val userAgent = System.getenv("IG_UA") ?: "Instagram 261.0.0.21.111 Android"

    val instagramHttpClient = HttpClient(CIO) {
        expectSuccess = false
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                explicitNulls = false
                prettyPrint = true
            })
        }
        install(ContentEncoding) { gzip(); deflate(); identity() }
        install(HttpTimeout) {
            connectTimeoutMillis = 10_000
            requestTimeoutMillis = 20_000
            socketTimeoutMillis = 20_000
        }
        defaultRequest {
            url { protocol = URLProtocol.HTTPS; host = "i.instagram.com" }
            header(HttpHeaders.UserAgent, userAgent)
            header("X-IG-App-ID", appId)
            if (sessionId.isNotBlank()) header(HttpHeaders.Cookie, "sessionid=$sessionId")
        }
    }
}

fun Application.configureClient() {
    Clients.instagramHttpClient
}
