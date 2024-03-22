package com.tirexmurina.nonpatternapp.domain.usecase

import com.tirexmurina.nonpatternapp.data.remote.ProductModel
import com.tirexmurina.nonpatternapp.domain.repository.ProductRepository

interface IGetProductsUseCase{
    suspend operator fun invoke() : List<ProductModel>
}

class GetProductsUseCase(
    private val repository : ProductRepository
) : IGetProductsUseCase {
    override suspend fun invoke(): List<ProductModel> {
        return repository.getProducts()
    }
}