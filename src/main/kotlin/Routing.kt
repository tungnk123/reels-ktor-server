package com.tungnk123

import InstagramService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import mapper.mapItemToDTO
import model.*

fun Application.configureRouting() {
    routing {
        get("/health") {
            call.respond(HealthResponse(status = "ok"))
        }

        get("/") {
            val docs = ApiDocs(
                name = "Instagram Reels Ktor Server",
                endpoints = listOf(
                    Endpoint("GET", "/user/{username}/id", "Get user ID by username"),
                    Endpoint("GET", "/user/{username}/stories", "Get all story items for a user (DTO)"),
                    Endpoint("GET", "/user/{username}/media", "Get processed media URLs with metadata"),
                    Endpoint("GET", "/raw/profile/{username}", "Get raw web profile JSON (debug)"),
                    Endpoint("GET", "/raw/reels/{userId}", "Get raw reels media JSON by userId (debug)"),
                    Endpoint("GET", "/health", "Health check endpoint")
                )
            )
            call.respond(docs)
        }

        get("/user/{username}/id") {
            val username = call.parameters.getOrFail("username")

            val userId = InstagramService.getUserId(username)
            if (userId == null) {
                call.respond(HttpStatusCode.NotFound, ErrorResponse("User not found"))
            } else {
                call.respond(UserIdResponse(username = username, userId = userId))
            }
        }

        get("/user/{username}/stories") {
            val username = call.parameters.getOrFail("username")

            val userId = InstagramService.getUserId(username)
            if (userId == null) {
                call.respond(HttpStatusCode.NotFound, ErrorResponse("User not found"))
                return@get
            }

            val items = InstagramService.getStories(userId)
            val dtoItems = items.map { mapItemToDTO(it) }

            call.respond(
                StoriesResponse(
                    username = username,
                    userId = userId,
                    count = dtoItems.size,
                    items = dtoItems
                )
            )
        }

        get("/user/{username}/media") {
            val username = call.parameters.getOrFail("username")

            val userId = InstagramService.getUserId(username)
            if (userId == null) {
                call.respond(HttpStatusCode.NotFound, ErrorResponse("User not found"))
                return@get
            }

            val media = InstagramService.getStoryMediaUrls(userId)
            call.respond(
                MediaListResponse(
                    username = username,
                    userId = userId,
                    items = media
                )
            )
        }

        get("/raw/profile/{username}") {
            val username = call.parameters.getOrFail("username")
            val raw = InstagramService.getWebProfileInfoRaw(username)
            if (raw == null) {
                call.respond(HttpStatusCode.BadGateway, ErrorResponse("Cannot fetch web_profile_info"))
            } else {
                call.respondText(raw, ContentType.Application.Json)
            }
        }

        get("/raw/reels/{userId}") {
            val userId = call.parameters.getOrFail("userId")
            val raw = InstagramService.getReelsMediaRaw(userId)
            if (raw == null) {
                call.respond(HttpStatusCode.BadGateway, ErrorResponse("Cannot fetch reels_media"))
            } else {
                call.respondText(raw, ContentType.Application.Json)
            }
        }
    }
}
