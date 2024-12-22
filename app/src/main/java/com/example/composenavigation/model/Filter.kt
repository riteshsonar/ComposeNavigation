package com.example.composenavigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.SortByAlpha
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

@Stable
data class Filter(
    val name: String,
    val enable: Boolean = false,
    val icon: ImageVector? = null
) {
    val enabled = mutableStateOf(enable)
}

val filter = listOf(
    Filter(name = "Organic"),
    Filter(name = "Gluten-free"),
    Filter(name = "Daily-free"),
    Filter(name = "Sweet"),
    Filter(name = "Savory")
)

val priceFilter = listOf(
    Filter(name = "$"),
    Filter(name = "$$"),
    Filter(name = "$$$"),
    Filter(name = "$$$$")
)

val sortFilters = listOf(
    Filter(name = "Android's Favorite (default)", icon = Icons.Filled.Android),
    Filter(name = "Rating", icon = Icons.Filled.Star),
    Filter(name = "Alphabetical", icon = Icons.Filled.SortByAlpha)
)

val categoryFilters = listOf(
    Filter(name = "Chips & crackers"),
    Filter(name = "Fruit snacks"),
    Filter(name = "Desserts"),
    Filter(name = "Nuts")
)
val lifeStyleFilters = listOf(
    Filter(name = "Organic"),
    Filter(name = "Gluten-free"),
    Filter(name = "Dairy-free"),
    Filter(name = "Sweet"),
    Filter(name = "Savory")
)

var sortDefault = sortFilters.get(0).name
