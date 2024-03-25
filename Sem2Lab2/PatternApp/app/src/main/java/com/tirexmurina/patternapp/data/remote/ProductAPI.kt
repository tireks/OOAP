package com.tirexmurina.patternapp.data.remote

import retrofit2.http.GET

interface ProductAPI {

    @GET("products")
    suspend fun getProducts() : ProductsResponse

}