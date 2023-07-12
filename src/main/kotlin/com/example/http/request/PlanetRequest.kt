package com.example.http.request

import kotlinx.serialization.Serializable

@Serializable
data class PlanetRequest(
    val name: String,
    val description: String,
    val size: String,
    val distanceFromSun: String,
    val isPopular: Boolean = false,
)
