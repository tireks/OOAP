package com.tirexmurina.patternapp.domain.repository

import com.tirexmurina.patternapp.domain.repository.entity.Product


interface ProductRepository {
    suspend fun getProducts() : List<Product>
}