package com.tirexmurina.nonpatternapp.domain.repository

import com.tirexmurina.nonpatternapp.data.remote.ProductModel

interface ProductRepository {
    suspend fun getProducts() : List<ProductModel>
}