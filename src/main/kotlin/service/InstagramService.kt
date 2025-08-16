import com.tungnk123.Clients
import com.tungnk123.model.MediaType
import com.tungnk123.model.WebProfileResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import model.*

object InstagramService {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    suspend fun getUserId(username: String): String? {
        val res = Clients.instagramHttpClient.get("/api/v1/users/web_profile_info/") {
            url { parameters.append("username", username) }
        }
        val raw = res.bodyAsText()
        println("📥 web_profile_info JSON:\n$raw")

        if (res.status != HttpStatusCode.OK) {
            println("❌ HTTP Error (web_profile_info): ${res.status}")
            return null
        }

        // Parse từ raw để thống nhất và an toàn
        val body = runCatching { json.decodeFromString<WebProfileResponse>(raw) }
            .onFailure { e -> println("❌ Parse web_profile_info failed: ${e.message}") }
            .getOrNull() ?: return null

        return body.data?.user?.id
    }

    private suspend fun getReelByUserId(userId: String): Reel? {
        val res = Clients.instagramHttpClient.get("/api/v1/feed/reels_media/") {
            url { parameters.append("reel_ids", userId) }
        }
        val raw = res.bodyAsText()
        println("📥 reels_media JSON:\n$raw")

        if (res.status != HttpStatusCode.OK) {
            println("❌ HTTP Error (reels_media): ${res.status}")
            return null
        }

        val body = runCatching { json.decodeFromString<InstagramStoriesResponse>(raw) }
            .onFailure { e -> println("❌ Parse reels_media failed: ${e.message}") }
            .getOrNull() ?: return null

        println("✅ Parsed reels_media • reels=${body.reels.size} • keys=${body.reels.keys}")

        val reel = body.reels.values.firstOrNull()
        reel?.let {
            println("📱 Reel: mediaCount=${it.mediaCount}, items=${it.items.size}, user=${it.user?.username}")
            it.items.firstOrNull()?.let { item ->
                println("🎬 First item: id=${item.id}, videos=${item.videoVersions?.size ?: 0}, images=${item.imageVersions2?.candidates?.size ?: 0}, ${item.originalWidth}x${item.originalHeight}, duration=${item.videoDuration}, hasAudio=${item.hasAudio}")
            }
        }
        return reel
    }

    suspend fun getStories(userId: String): List<StoryItem> {
        val reel = getReelByUserId(userId) ?: return emptyList()
        return reel.items
    }

    suspend fun getStoryMediaUrls(userId: String): List<StoryMediaInfo> {
        val stories = getStories(userId)
        return stories.mapNotNull { story ->
            when (story.mediaType) {
                1 -> {
                    val bestImage = story.imageVersions2
                        ?.candidates
                        ?.maxByOrNull { it.width ?: 0 }
                    bestImage?.let { img ->
                        StoryMediaInfo(
                            id = story.id,
                            type = MediaType.IMAGE,
                            url = img.url,
                            width = img.width,
                            height = img.height,
                            duration = null
                        )
                    }
                }

                2 -> {
                    val bestVideo = story.videoVersions
                        ?.sortedWith(
                            compareBy<VideoVersion>(
                                { it.height ?: 0 },
                                { it.bandwidth ?: 0L }
                            )
                        )
                        ?.lastOrNull()
                    bestVideo?.let { v ->
                        StoryMediaInfo(
                            id = story.id,
                            type = MediaType.VIDEO,
                            url = v.url,
                            width = v.width,
                            height = v.height,
                            duration = story.videoDuration
                        )
                    }
                }

                else -> null
            }
        }
    }
}