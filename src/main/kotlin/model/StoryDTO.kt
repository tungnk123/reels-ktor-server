package model

import kotlinx.serialization.Serializable

@Serializable
data class StoryDTO(
    val id: String,
    val type: String,
    val videoUrls: List<String> = emptyList(),
    val imageUrl: String? = null,
    val caption: String = "",
    val duration: Double? = null,
    val hasAudio: Boolean? = null,
    val code: String? = null
)
