package com.tirexmurina.patternapp.presentation

import com.tirexmurina.patternapp.domain.repository.entity.Product


sealed class HomeState{
    data object Initial : HomeState()
    data class Content(
        val items: List<Product>
    ): HomeState()
}
