package com.example.practiceep.data.remote

import com.example.practiceep.data.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("search?query={text_query}&number=50&apiKey={api_token}")
    fun searchByName(
        @Path("text_query") textQuery: String,
        @Path("api_token") apiToken: String = "ff767bd4315b4d388b050fc37024eb96"
    ): Call<ProductResponse>

    @GET("{id_product}?apiKey={api_token}")
    fun searchById(
        @Path("id_product") idProduct: Int,
        @Path("api_token") apiToken: String="ff767bd4315b4d388b050fc37024eb96"
    ): Call<Product>
}