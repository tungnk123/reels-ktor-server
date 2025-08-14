package com.tungnk123.model

import kotlinx.serialization.Serializable

@Serializable
data class WebProfileResponse(
    val data: WebData? = null,
    val status: String? = null
) {
    @Serializable
    data class WebData(
        val user: WebUser? = null
    )

    @Serializable
    data class WebUser(
        val id: String? = null,
        val username: String? = null,
        val full_name: String? = null,
        val biography: String? = null
    )
}
