package com.example.practiceep.data.remote

import com.example.practiceep.data.model.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("results")
    val products: List<Product>
)