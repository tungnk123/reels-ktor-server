package com.tungnk123

import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import kotlinx.serialization.json.Json

object Clients {
    private val dotenv = dotenv()

    private val localEnv = dotenv {
        ignoreIfMissing = true
        ignoreIfMalformed = true
    }

    private val sessionId = env(name = "IG_SESSION_ID", default = "")
    private val appId = env(name = "IG_APP_ID", default = "567067343352427")
    private val userAgent = env(name = "IG_UA", default = "Instagram 261.0.0.21.111 Android")

    private fun env(name: String, default: String): String =
        System.getenv(name) ?: localEnv[name] ?: default


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
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
            filter { request ->
                request.url.host.contains("instagram")
            }
            sanitizeHeader { header ->
                header.equals(HttpHeaders.Authorization, true) ||
                        header.equals(HttpHeaders.Cookie, true) ||
                        header.equals("X-IG-WWW-Claim", true)
            }
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
