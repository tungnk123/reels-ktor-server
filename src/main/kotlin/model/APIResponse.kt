package model

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(val error: String)

@Serializable
data class UserIdResponse(val username: String, val userId: String)

@Serializable
data class StoriesResponse(
    val username: String,
    val userId: String,
    val count: Int,
    val items: List<StoryDTO>
)

@Serializable
data class MediaListResponse(
    val username: String,
    val userId: String,
    val items: List<StoryMediaInfo>
)

@Serializable
data class HealthResponse(val status: String = "ok")
