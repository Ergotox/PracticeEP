package com.example.practiceep.data.model

data class Product(
    val id: Int,
    val name: String,
    val image: ProductImage,
    var isFavorite: Boolean
)
data class ProductImage(
    val url:String
)