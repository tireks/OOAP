package com.tirexmurina.nonpatternapp.presentation.screen

import com.tirexmurina.nonpatternapp.data.remote.ProductModel

sealed class HomeState{
    data object Initial : HomeState()
    data class Content(
        val items: List<ProductModel>
    ): HomeState()
}
