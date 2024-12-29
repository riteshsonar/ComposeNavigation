package com.example.composenavigation.model

import androidx.compose.runtime.Immutable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import com.example.composenavigation.R


object searchRepo {

    fun getCategories(): List<SearchCategoryCollection> = searchCategoryCollections
    fun getSuggestions(): List<SearchSuggestionGroup> = searchSuggestions

    suspend fun search(query: String): List<Snack> = withContext(Dispatchers.Default) {
        delay(200L)
        snacks.filter { it.name.contains(query,ignoreCase = true)}
    }
}

@Immutable
data class SearchCategoryCollection(val id : Long, val name: String, val categories: List<SearchCategory>)

@Immutable
data class SearchCategory(val name: String, val imageRes: Int)

@Immutable
data class SearchSuggestionGroup(val id: Long, val name: String, val suggestions: List<String>)

private val searchCategoryCollections = listOf(
    SearchCategoryCollection(
        id = 0L,
        name = "Categories",
        categories = listOf(
            SearchCategory(
                name = "Chips & crackers",
                imageRes = R.drawable.chips
            ),
            SearchCategory(
                name = "Fruit snacks",
                imageRes = R.drawable.fruit,
            ),
            SearchCategory(
                name = "Desserts",
                imageRes = R.drawable.desserts
            ),
            SearchCategory(
                name = "Nuts",
                imageRes = R.drawable.nuts,
            ),
            SearchCategory(
                name = "Vegitable",
                imageRes = R.drawable.fruit,
            )
        )
    ),
    SearchCategoryCollection(
        id = 1L,
        name = "Lifestyles",
        categories = listOf(
            SearchCategory(
                name = "Organic",
                imageRes = R.drawable.organic
            ),
            SearchCategory(
                name = "Gluten Free",
                imageRes = R.drawable.gluten_free
            ),
            SearchCategory(
                name = "Paleo",
                imageRes = R.drawable.paleo,
            ),
            SearchCategory(
                name = "Vegan",
                imageRes = R.drawable.vegan,
            ),
            SearchCategory(
                name = "Vegetarian",
                imageRes = R.drawable.organic,
            ),
            SearchCategory(
                name = "Whole30",
                imageRes = R.drawable.paleo
            )
        )
    )
)

private val searchSuggestions = listOf(
    SearchSuggestionGroup(
        id = 0L,
        name = "Recent searches",
        suggestions = listOf(
            "cheese", "apple  Sauce"
        )
    ),
    SearchSuggestionGroup(
        id = 1L,
        name = "Popular searches",
        suggestions = listOf(
            "Organic",
            "Gluten Free",
            "Paleo",
            "Vegan",
            "Vegitarian",
            "Whole30"
        )
    )
)