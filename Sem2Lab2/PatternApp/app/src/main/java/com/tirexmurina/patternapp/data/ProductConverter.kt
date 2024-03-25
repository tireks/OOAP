package com.tirexmurina.patternapp.data

import com.tirexmurina.patternapp.data.remote.ProductModel
import com.tirexmurina.patternapp.domain.repository.entity.Product

class ProductConverter {
    fun convert(from: ProductModel): Product =
        with(from){
            Product(
                id = id,
                description = description,
                title = title,
                brand = brand,
                rating = rating,
                stock = stock,
                price = price,
                discountPercentage = discountPercentage,
                category = category,
                images = listOf(thumbnail) + images
            )
        }
}