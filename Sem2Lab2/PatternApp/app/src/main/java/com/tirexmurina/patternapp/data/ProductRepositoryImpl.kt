package com.tirexmurina.patternapp.data

import com.tirexmurina.patternapp.data.remote.ProductAPI
import com.tirexmurina.patternapp.data.remote.ProductModel
import com.tirexmurina.patternapp.domain.repository.ProductRepository
import com.tirexmurina.patternapp.domain.repository.entity.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductRepositoryImpl : ProductRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi by lazy {
        retrofit.create(ProductAPI::class.java)
    }

    private val converter = ProductConverter()

    override suspend fun getProducts(): List<Product> =
        productApi.getProducts().products.map { converter.convert(it) }

}