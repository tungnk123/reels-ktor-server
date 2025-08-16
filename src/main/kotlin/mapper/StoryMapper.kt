package mapper

import model.StoryDTO
import model.StoryItem

fun mapItemToDTO(item: StoryItem): StoryDTO {
    val videoUrls = item.videoVersions?.map { it.url } ?: emptyList()

    val imageUrl = item.imageVersions2
        ?.candidates
        ?.maxByOrNull { it.width ?: 0 }
        ?.url

    val type = when {
        item.mediaType == 2 -> "video"
        item.mediaType == 1 -> "image"
        videoUrls.isNotEmpty() -> "video"
        else -> "image"
    }

    return StoryDTO(
        id = item.id,
        type = type,
        videoUrls = videoUrls,
        imageUrl = imageUrl,
        caption = item.caption?.text.orEmpty(),
        duration = item.videoDuration,
        hasAudio = item.hasAudio,
        code = item.code
    )
}