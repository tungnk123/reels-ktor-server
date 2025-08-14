package mapper

import com.tungnk123.model.ReelsMediaResponse
import model.StoryDTO

fun mapItemToDTO(item: ReelsMediaResponse.Item): StoryDTO {
    val videos = item.videoVersions?.map { it.url }.orEmpty()
    val image = item.image?.candidates?.firstOrNull()?.url
    val type = if (videos.isNotEmpty()) "video" else "image"
    return StoryDTO(
        id = item.id,
        type = type,
        videoUrls = videos,
        imageUrl = image,
        caption = item.caption?.text.orEmpty(),
        duration = item.videoDuration,
        hasAudio = item.hasAudio,
        code = item.code
    )
}
