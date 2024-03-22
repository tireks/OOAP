package com.tirexmurina.nonpatternapp.data

import com.tirexmurina.nonpatternapp.data.remote.ProductAPI
import com.tirexmurina.nonpatternapp.data.remote.ProductModel
import com.tirexmurina.nonpatternapp.domain.repository.ProductRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ProductRepositoryImpl : ProductRepository{

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi by lazy {
        retrofit.create(ProductAPI::class.java)
    }

    override suspend fun getProducts(): List<ProductModel> =
        productApi.getProducts().products

}