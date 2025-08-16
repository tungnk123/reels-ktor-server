package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class InstagramStoriesResponse(
    val reels: Map<String, Reel> = emptyMap(),
    val status: String? = null
)

@Serializable
data class Reel(
    val id: Long? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    @SerialName("latest_reel_media") val latestReelMedia: Long? = null,
    val seen: Int? = null,
    @SerialName("can_reply") val canReply: Boolean? = null,
    @SerialName("can_gif_quick_reply") val canGifQuickReply: Boolean? = null,
    @SerialName("can_reshare") val canReshare: Boolean? = null,
    @SerialName("reel_type") val reelType: String? = null,
    @SerialName("ad_expiry_timestamp_in_millis") val adExpiryTimestamp: Long? = null,
    @SerialName("is_cta_sticker_available") val isCtaStickerAvailable: Boolean? = null,
    @SerialName("app_sticker_info") val appStickerInfo: JsonElement? = null,
    @SerialName("should_treat_link_sticker_as_cta") val shouldTreatLinkStickerAsCta: Boolean? = null,
    @SerialName("pool_refresh_ttl_in_sec") val poolRefreshTtl: Int? = null,
    @SerialName("can_react_with_avatar") val canReactWithAvatar: Boolean? = null,
    @SerialName("expiring_at") val expiringAt: Long? = null,
    val user: ReelUser? = null,
    val items: List<StoryItem> = emptyList(),
    @SerialName("is_nux") val isNux: Boolean? = null,
    @SerialName("prefetch_count") val prefetchCount: Int? = null,
    @SerialName("media_count") val mediaCount: Int? = null,
    @SerialName("media_ids") val mediaIds: List<Long>? = null,
    @SerialName("is_cacheable") val isCacheable: Boolean? = null,
    @SerialName("disabled_reply_types") val disabledReplyTypes: List<String>? = null,
    @SerialName("is_archived") val isArchived: Boolean? = null,
    @SerialName("show_expiration_tray_signal") val showExpirationTraySignal: Boolean? = null
)

@Serializable
data class ReelUser(
    val pk: Long? = null,
    @SerialName("pk_id") val pkId: String? = null,
    @SerialName("full_name") val fullName: String? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    val id: String? = null,
    val username: String? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null,
    @SerialName("is_ring_creator") val isRingCreator: Boolean? = null,
    @SerialName("show_ring_award") val showRingAward: Boolean? = null,
    @SerialName("is_verified") val isVerified: Boolean? = null,
    @SerialName("profile_pic_id") val profilePicId: String? = null,
    @SerialName("profile_pic_url") val profilePicUrl: String? = null,
    @SerialName("interop_messaging_user_fbid") val interopMessagingUserFbid: Long? = null,
    @SerialName("is_creator_agent_enabled") val isCreatorAgentEnabled: Boolean? = null,
    @SerialName("transparency_product_enabled") val transparencyProductEnabled: Boolean? = null,
    @SerialName("friendship_status") val friendshipStatus: FriendshipStatus? = null
)

@Serializable
data class FriendshipStatus(
    val following: Boolean? = null,
    @SerialName("is_bestie") val isBestie: Boolean? = null,
    @SerialName("is_feed_favorite") val isFeedFavorite: Boolean? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null,
    @SerialName("is_restricted") val isRestricted: Boolean? = null,
    @SerialName("incoming_request") val incomingRequest: Boolean? = null,
    @SerialName("outgoing_request") val outgoingRequest: Boolean? = null
)

@Serializable
data class StoryItem(
    val pk: Long? = null,
    val id: String,
    @SerialName("is_visual_reply_commenter_notice_enabled") val isVisualReplyCommenterNoticeEnabled: Boolean? = null,
    @SerialName("like_and_view_counts_disabled") val likeAndViewCountsDisabled: Boolean? = null,
    @SerialName("is_post_live_clips_media") val isPostLiveClipsMedia: Boolean? = null,
    @SerialName("is_reshare_of_text_post_app_media_in_ig") val isReshareOfTextPostAppMediaInIg: Boolean? = null,
    @SerialName("is_reel_media") val isReelMedia: Boolean? = null,
    val fbid: Long? = null,
    @SerialName("device_timestamp") val deviceTimestamp: Long? = null,
    @SerialName("caption_is_edited") val captionIsEdited: Boolean? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    @SerialName("is_quicksnap_recap") val isQuicksnapRecap: Boolean? = null,
    @SerialName("deleted_reason") val deletedReason: Int? = null,
    @SerialName("expiring_at") val expiringAt: Long? = null,
    @SerialName("mezql_token") val mezqlToken: String? = null,
    @SerialName("should_request_ads") val shouldRequestAds: Boolean? = null,
    @SerialName("is_terminal_video_segment") val isTerminalVideoSegment: Boolean? = null,
    @SerialName("integrity_review_decision") val integrityReviewDecision: String? = null,
    @SerialName("client_cache_key") val clientCacheKey: String? = null,
    @SerialName("has_privately_liked") val hasPrivatelyLiked: Boolean? = null,
    @SerialName("filter_type") val filterType: Int? = null,
    @SerialName("taken_at") val takenAt: Long? = null,
    @SerialName("commenting_disabled_for_viewer") val commentingDisabledForViewer: Boolean? = null,
    @SerialName("hide_view_all_comment_entrypoint") val hideViewAllCommentEntrypoint: Boolean? = null,
    @SerialName("is_comments_gif_composer_enabled") val isCommentsGifComposerEnabled: Boolean? = null,
    @SerialName("has_liked") val hasLiked: Boolean? = null,
    @SerialName("video_sticker_locales") val videoStickerLocales: List<String>? = null,
    @SerialName("is_dash_eligible") val isDashEligible: Int? = null,
    @SerialName("video_dash_manifest") val videoDashManifest: String? = null,
    @SerialName("video_codec") val videoCodec: String? = null,
    @SerialName("number_of_qualities") val numberOfQualities: Int? = null,
    @SerialName("video_versions") val videoVersions: List<VideoVersion>? = null,
    @SerialName("video_duration") val videoDuration: Double? = null,
    @SerialName("has_audio") val hasAudio: Boolean? = null,
    @SerialName("can_viewer_save") val canViewerSave: Boolean? = null,
    @SerialName("shop_routing_user_id") val shopRoutingUserId: String? = null,
    @SerialName("is_organic_product_tagging_eligible") val isOrganicProductTaggingEligible: Boolean? = null,
    @SerialName("product_suggestions") val productSuggestions: List<JsonElement>? = null,
    @SerialName("can_see_insights_as_brand") val canSeeInsightsAsBrand: Boolean? = null,
    @SerialName("media_type") val mediaType: Int? = null,
    val code: String? = null,
    val caption: Caption? = null,
    @SerialName("fundraiser_tag") val fundraiserTag: FundraiserTag? = null,
    @SerialName("sharing_friction_info") val sharingFrictionInfo: SharingFrictionInfo? = null,
    @SerialName("has_translation") val hasTranslation: Boolean? = null,
    @SerialName("original_media_has_visual_reply_media") val originalMediaHasVisualReplyMedia: Boolean? = null,
    @SerialName("coauthor_producers") val coauthorProducers: List<JsonElement>? = null,
    @SerialName("coauthor_producer_can_see_organic_insights") val coauthorProducerCanSeeOrganicInsights: Boolean? = null,
    @SerialName("invited_coauthor_producers") val invitedCoauthorProducers: List<JsonElement>? = null,
    @SerialName("media_overlay_info") val mediaOverlayInfo: JsonElement? = null,
    @SerialName("is_in_profile_grid") val isInProfileGrid: Boolean? = null,
    @SerialName("profile_grid_control_enabled") val profileGridControlEnabled: Boolean? = null,
    @SerialName("image_versions2") val imageVersions2: ImageVersions2? = null,
    @SerialName("original_width") val originalWidth: Int? = null,
    @SerialName("original_height") val originalHeight: Int? = null,
    @SerialName("product_type") val productType: String? = null,
    @SerialName("is_paid_partnership") val isPaidPartnership: Boolean? = null,
    @SerialName("music_metadata") val musicMetadata: JsonElement? = null,
    @SerialName("organic_tracking_token") val organicTrackingToken: String? = null,
    @SerialName("ig_media_sharing_disabled") val igMediaSharingDisabled: Boolean? = null,
    @SerialName("crosspost_metadata") val crosspostMetadata: CrosspostMetadata? = null,
    @SerialName("boost_unavailable_identifier") val boostUnavailableIdentifier: String? = null,
    @SerialName("boost_unavailable_reason") val boostUnavailableReason: String? = null,
    @SerialName("boost_unavailable_reason_v2") val boostUnavailableReasonV2: String? = null,
    @SerialName("creative_config") val creativeConfig: JsonElement? = null,
    @SerialName("is_cutout_sticker_allowed") val isCutoutStickerAllowed: Boolean? = null,
    @SerialName("cutout_sticker_info") val cutoutStickerInfo: List<JsonElement>? = null,
    @SerialName("gen_ai_detection_method") val genAiDetectionMethod: GenAiDetectionMethod? = null,
    @SerialName("fb_aggregated_like_count") val fbAggregatedLikeCount: Int? = null,
    @SerialName("fb_aggregated_comment_count") val fbAggregatedCommentCount: Int? = null,
    @SerialName("has_high_risk_gen_ai_inform_treatment") val hasHighRiskGenAiInformTreatment: Boolean? = null,
    @SerialName("open_carousel_show_follow_button") val openCarouselShowFollowButton: Boolean? = null,
    @SerialName("is_tagged_media_shared_to_viewer_profile_grid") val isTaggedMediaSharedToViewerProfileGrid: Boolean? = null,
    @SerialName("should_show_author_pog_for_tagged_media_shared_to_profile_grid") val shouldShowAuthorPogForTaggedMediaSharedToProfileGrid: Boolean? = null,
    @SerialName("is_open_to_public_submission") val isOpenToPublicSubmission: Boolean? = null,
    @SerialName("media_attributions_data") val mediaAttributionsData: List<JsonElement>? = null,
    @SerialName("archive_story_deletion_ts") val archiveStoryDeletionTs: Long? = null,
    @SerialName("can_send_prompt") val canSendPrompt: Boolean? = null,
    @SerialName("is_first_take") val isFirstTake: Boolean? = null,
    @SerialName("is_from_discovery_surface") val isFromDiscoverySurface: Boolean? = null,
    @SerialName("is_rollcall_v2") val isRollcallV2: Boolean? = null,
    @SerialName("supports_reel_reactions") val supportsReelReactions: Boolean? = null,
    @SerialName("is_photo_mash_story") val isPhotoMashStory: Boolean? = null,
    @SerialName("can_play_spotify_audio") val canPlaySpotifyAudio: Boolean? = null,
    @SerialName("can_reshare") val canReshare: Boolean? = null,
    @SerialName("is_superlative") val isSuperlative: Boolean? = null,
    @SerialName("reel_mentions") val reelMentions: List<ReelMention>? = null,
    @SerialName("reshared_story_media_author") val resharedStoryMediaAuthor: ResharedStoryMediaAuthor? = null,
    @SerialName("show_one_tap_fb_share_tooltip") val showOneTapFbShareTooltip: Boolean? = null,
    @SerialName("story_music_stickers") val storyMusicStickers: List<StoryMusicSticker>? = null,
    val user: StoryUser? = null
)

@Serializable
data class VideoVersion(
    val bandwidth: Long? = null,
    val height: Int? = null,
    val id: String? = null,
    val type: Int? = null,
    val url: String,
    val width: Int? = null
)

@Serializable
data class ImageVersions2(
    val candidates: List<ImageCandidate> = emptyList()
)

@Serializable
data class ImageCandidate(
    @SerialName("estimated_scans_sizes") val estimatedScansSizes: List<Int>? = null,
    val height: Int? = null,
    @SerialName("scans_profile") val scansProfile: String? = null,
    val url: String,
    val width: Int? = null
)

@Serializable
data class Caption(
    val text: String? = null
)

@Serializable
data class FundraiserTag(
    @SerialName("has_standalone_fundraiser") val hasStandaloneFundraiser: Boolean? = null
)

@Serializable
data class SharingFrictionInfo(
    @SerialName("bloks_app_url") val bloksAppUrl: String? = null,
    @SerialName("should_have_sharing_friction") val shouldHaveSharingFriction: Boolean? = null,
    @SerialName("sharing_friction_payload") val sharingFrictionPayload: String? = null
)

@Serializable
data class CrosspostMetadata(
    @SerialName("fb_downstream_use_xpost_metadata") val fbDownstreamUseXpostMetadata: FbDownstreamUseXpostMetadata? = null
)

@Serializable
data class FbDownstreamUseXpostMetadata(
    @SerialName("downstream_use_xpost_deny_reason") val downstreamUseXpostDenyReason: String? = null
)

@Serializable
data class GenAiDetectionMethod(
    @SerialName("detection_method") val detectionMethod: String? = null
)

@Serializable
data class ReelMention(
    @SerialName("display_type") val displayType: String? = null,
    @SerialName("end_time_ms") val endTimeMs: Double? = null,
    val height: Double? = null,
    @SerialName("is_fb_sticker") val isFbSticker: Int? = null,
    @SerialName("is_hidden") val isHidden: Int? = null,
    @SerialName("is_pinned") val isPinned: Int? = null,
    @SerialName("is_sticker") val isSticker: Int? = null,
    val rotation: Double? = null,
    @SerialName("start_time_ms") val startTimeMs: Double? = null,
    val user: MentionUser? = null,
    val width: Double? = null,
    val x: Double? = null,
    val y: Double? = null,
    val z: Int? = null
)

@Serializable
data class MentionUser(
    val pk: Long? = null,
    @SerialName("pk_id") val pkId: String? = null,
    @SerialName("full_name") val fullName: String? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    val id: String? = null,
    val username: String? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null,
    @SerialName("is_verified") val isVerified: Boolean? = null,
    @SerialName("profile_pic_url") val profilePicUrl: String? = null
)

@Serializable
data class ResharedStoryMediaAuthor(
    val pk: Long? = null,
    @SerialName("pk_id") val pkId: String? = null,
    val id: String? = null,
    @SerialName("full_name") val fullName: String? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    val username: String? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null,
    @SerialName("is_verified") val isVerified: Boolean? = null,
    @SerialName("profile_pic_url") val profilePicUrl: String? = null
)

@Serializable
data class StoryMusicSticker(
    val attribution: String? = null,
    @SerialName("end_time_ms") val endTimeMs: Double? = null,
    val height: Double? = null,
    @SerialName("is_fb_sticker") val isFbSticker: Int? = null,
    @SerialName("is_hidden") val isHidden: Int? = null,
    @SerialName("is_pinned") val isPinned: Int? = null,
    @SerialName("is_sticker") val isSticker: Int? = null,
    val rotation: Double? = null,
    @SerialName("start_time_ms") val startTimeMs: Double? = null,
    val width: Double? = null,
    val x: Double? = null,
    val y: Double? = null,
    val z: Int? = null,
    @SerialName("music_asset_info") val musicAssetInfo: MusicAssetInfo? = null
)

@Serializable
data class MusicAssetInfo(
    @SerialName("allow_media_creation_with_music") val allowMediaCreationWithMusic: Boolean? = null,
    @SerialName("allows_saving") val allowsSaving: Boolean? = null,
    @SerialName("artist_id") val artistId: String? = null,
    @SerialName("audio_asset_id") val audioAssetId: String? = null,
    @SerialName("audio_asset_start_time_in_ms") val audioAssetStartTimeInMs: Int? = null,
    @SerialName("audio_cluster_id") val audioClusterId: String? = null,
    @SerialName("contains_lyrics") val containsLyrics: Boolean? = null,
    @SerialName("cover_artwork_thumbnail_uri") val coverArtworkThumbnailUri: String? = null,
    @SerialName("cover_artwork_uri") val coverArtworkUri: String? = null,
    @SerialName("dark_message") val darkMessage: String? = null,
    @SerialName("dash_manifest") val dashManifest: String? = null,
    @SerialName("derived_content_id") val derivedContentId: String? = null,
    @SerialName("display_artist") val displayArtist: String? = null,
    @SerialName("display_labels") val displayLabels: String? = null,
    @SerialName("duration_in_ms") val durationInMs: Long? = null,
    @SerialName("fast_start_progressive_download_url") val fastStartProgressiveDownloadUrl: String? = null,
    @SerialName("formatted_clips_media_count") val formattedClipsMediaCount: String? = null,
    @SerialName("has_lyrics") val hasLyrics: Boolean? = null,
    @SerialName("highlight_start_times_in_ms") val highlightStartTimesInMs: List<Int>? = null,
    val id: String? = null,
    @SerialName("ig_username") val igUsername: String? = null,
    @SerialName("is_bookmarked") val isBookmarked: Boolean? = null,
    @SerialName("is_eligible_for_audio_effects") val isEligibleForAudioEffects: Boolean? = null,
    @SerialName("is_eligible_for_vinyl_sticker") val isEligibleForVinylSticker: Boolean? = null,
    @SerialName("is_explicit") val isExplicit: Boolean? = null,
    @SerialName("is_trending_in_clips") val isTrendingInClips: Boolean? = null,
    @SerialName("licensed_music_subtype") val licensedMusicSubtype: String? = null,
    @SerialName("music_creation_restriction_reason") val musicCreationRestrictionReason: String? = null,
    @SerialName("overlap_duration_in_ms") val overlapDurationInMs: Long? = null,
    @SerialName("placeholder_profile_pic_url") val placeholderProfilePicUrl: String? = null,
    @SerialName("previous_trend_rank") val previousTrendRank: Int? = null,
    @SerialName("progressive_download_url") val progressiveDownloadUrl: String? = null,
    @SerialName("reactive_audio_download_url") val reactiveAudioDownloadUrl: String? = null,
    @SerialName("sanitized_title") val sanitizedTitle: String? = null,
    @SerialName("should_allow_music_editing") val shouldAllowMusicEditing: Boolean? = null,
    @SerialName("should_mute_audio") val shouldMuteAudio: Boolean? = null,
    @SerialName("should_mute_audio_reason") val shouldMuteAudioReason: String? = null,
    @SerialName("should_mute_audio_reason_type") val shouldMuteAudioReasonType: String? = null,
    @SerialName("should_render_soundwave") val shouldRenderSoundwave: Boolean? = null,
    @SerialName("song_monetization_info") val songMonetizationInfo: JsonElement? = null,
    val subtitle: String? = null,
    val title: String? = null,
    @SerialName("trend_rank") val trendRank: Int? = null,
    @SerialName("web_30s_preview_download_url") val web30sPreviewDownloadUrl: String? = null,
    @SerialName("ig_artist") val igArtist: IgArtist? = null,
    @SerialName("audio_filter_infos") val audioFilterInfos: List<JsonElement>? = null,
    @SerialName("audio_muting_info") val audioMutingInfo: AudioMutingInfo? = null,
    val lyrics: String? = null,
    @SerialName("spotify_track_metadata") val spotifyTrackMetadata: JsonElement? = null,
    @SerialName("user_notes") val userNotes: JsonElement? = null
)

@Serializable
data class IgArtist(
    val pk: Long? = null,
    @SerialName("pk_id") val pkId: String? = null,
    val id: String? = null,
    val username: String? = null,
    @SerialName("full_name") val fullName: String? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null,
    @SerialName("is_verified") val isVerified: Boolean? = null,
    @SerialName("profile_pic_id") val profilePicId: String? = null,
    @SerialName("profile_pic_url") val profilePicUrl: String? = null,
    @SerialName("strong_id__") val strongId: String? = null
)

@Serializable
data class AudioMutingInfo(
    @SerialName("mute_audio") val muteAudio: Boolean? = null,
    @SerialName("mute_reason_str") val muteReasonStr: String? = null,
    @SerialName("allow_audio_editing") val allowAudioEditing: Boolean? = null,
    @SerialName("show_muted_audio_toast") val showMutedAudioToast: Boolean? = null
)

@Serializable
data class StoryUser(
    val pk: Long? = null,
    val id: String? = null,
    @SerialName("strong_id__") val strongId: String? = null,
    @SerialName("is_private") val isPrivate: Boolean? = null
)