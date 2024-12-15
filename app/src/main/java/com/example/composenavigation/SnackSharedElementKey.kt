package com.example.composenavigation

data class SnackSharedElementKey(
    val snackId: Long,
    val origin: String,
    val type: SnackSharedElementType,
)

enum class SnackSharedElementType {
    Bounds,
    Image,
    Title,
    Tagline,
    Background
}

object FilterSharedElementKey