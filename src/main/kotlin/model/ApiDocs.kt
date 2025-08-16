package model

import kotlinx.serialization.Serializable

@Serializable
data class ApiDocs(
    val name: String,
    val endpoints: List<Endpoint>
)

@Serializable
data class Endpoint(
    val method: String,
    val path: String,
    val desc: String
)
