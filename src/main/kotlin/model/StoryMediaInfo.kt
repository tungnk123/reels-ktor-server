package model

import com.tungnk123.model.MediaType
import kotlinx.serialization.Serializable

@Serializable
data class StoryMediaInfo(
    val id: String,
    val type: MediaType,
    val url: String,
    val width: Int?,
    val height: Int?,
    val duration: Double?
)