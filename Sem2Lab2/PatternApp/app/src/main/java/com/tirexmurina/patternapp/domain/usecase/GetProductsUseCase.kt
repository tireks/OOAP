package com.tirexmurina.patternapp.domain.usecase

import com.tirexmurina.patternapp.domain.repository.ProductRepository
import com.tirexmurina.patternapp.domain.repository.entity.Product

interface IGetProductsUseCase{
    suspend operator fun invoke() : List<Product>
}

class GetProductsUseCase(
    private val repository : ProductRepository
) : IGetProductsUseCase {
    override suspend fun invoke(): List<Product> {
        return repository.getProducts()
    }
}