package com.tirexmurina.nonpatternapp.data.remote

import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductAPI {

    @GET("products")
    suspend fun getProducts() : ProductsResponse

}