package service

import com.tungnk123.Clients
import com.tungnk123.model.ReelsMediaResponse
import com.tungnk123.model.WebProfileResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

object InstagramService {

    suspend fun getUserId(username: String): String? {
        val res = Clients.instagramHttpClient.get("/api/v1/users/web_profile_info/") {
            url { parameters.append("username", username) }
        }
        if (res.status != HttpStatusCode.OK) return null
        val body = res.body<WebProfileResponse>()
        return body.data?.user?.id
    }

    suspend fun getReelByUserId(userId: String): ReelsMediaResponse.Reel? {
        val res = Clients.instagramHttpClient.get("/api/v1/feed/reels_media/") {
            url { parameters.append("reel_ids", userId) }
        }
        if (res.status != HttpStatusCode.OK) return null
        val body = res.body<ReelsMediaResponse>()
        return body.reels.values.firstOrNull()
    }

    suspend fun getStories(userId: String): List<ReelsMediaResponse.Item> {
        val reel = getReelByUserId(userId) ?: return emptyList()
        return reel.items
    }
}
