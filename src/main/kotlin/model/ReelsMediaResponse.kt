package com.tungnk123.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReelsMediaResponse(
    val reels: Map<String, Reel> = emptyMap(),
    val status: String? = null
) {
    @Serializable
    data class Reel(
        val id: Long? = null,
        @SerialName("strong_id__") val strongId: String? = null,
        @SerialName("latest_reel_media") val latestReelMedia: Long? = null,
        val user: ReelUser? = null,
        val items: List<Item> = emptyList(),
        @SerialName("media_count") val mediaCount: Int? = null
    )

    @Serializable
    data class ReelUser(
        val pk: Long? = null,
        val id: String? = null,
        val username: String? = null,
        val full_name: String? = null,
        @SerialName("is_private") val isPrivate: Boolean? = null,
        @SerialName("is_verified") val isVerified: Boolean? = null,
        @SerialName("profile_pic_url") val profilePicUrl: String? = null
    )

    @Serializable
    data class Item(
        val pk: Long? = null,
        val id: String,
        val code: String? = null,
        @SerialName("media_type") val mediaType: Int? = null,
        @SerialName("original_width") val originalWidth: Int? = null,
        @SerialName("original_height") val originalHeight: Int? = null,
        @SerialName("video_duration") val videoDuration: Double? = null,
        @SerialName("has_audio") val hasAudio: Boolean? = null,
        @SerialName("image_versions2") val image: ImageVersions2? = null,
        @SerialName("video_versions") val videoVersions: List<VideoVersion>? = null,
        @SerialName("video_dash_manifest") val videoDashManifest: String? = null,
        val caption: Caption? = null
    )

    @Serializable
    data class ImageVersions2(
        val candidates: List<Candidate> = emptyList()
    )

    @Serializable
    data class Candidate(
        val url: String,
        val width: Int? = null,
        val height: Int? = null
    )

    @Serializable
    data class VideoVersion(
        val url: String,
        val type: Int? = null,
        val width: Int? = null,
        val height: Int? = null,
        val bandwidth: Long? = null,
        val id: String? = null
    )

    @Serializable
    data class Caption(
        val text: String? = null
    )
}
