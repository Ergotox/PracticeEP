package com.example.practiceep.repository

import com.example.practiceep.data.local.ProductDao
import com.example.practiceep.data.model.Product
import com.example.practiceep.data.model.ProductEntity
import com.example.practiceep.data.remote.ApiClient
import com.example.practiceep.data.remote.ProductResponse
import com.example.practiceep.data.remote.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.practiceep.utils.Result
class ProductRepository (
    private val productService: ProductService = ApiClient.getProductService(),
    private val productDao: ProductDao
){
    fun searchByName(name: String, callback: (Result<List<Product>>)->Unit){
        val searchByName = productService.searchByName(textQuery = name)
        searchByName.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>){
                if(response.isSuccessful){
                    try{
                        val products = response.body()!!.products
                        products.forEach{product ->
                            product.isFavorite = false
                        }
                        callback(Result.Success(response.body()!!.products))
                    }catch (e: Exception){
                        callback(Result.Success(listOf<Product>()))
                    }
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                callback(Result.Error(t.localizedMessage as String))
            }
        })
    }
    fun searchById(id: Int, callback: (Result<Product>) -> Unit) {
        val searchById = productService.searchById(idProduct = id)

        searchById.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {
                    callback(Result.Success(response.body()!!))
                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                callback(Result.Error(t.localizedMessage as String))
            }
        })
    }
    fun save(product: Product){
        productDao.save(ProductEntity(product.id))
    }
    fun delete(product: Product){
        productDao.delete(ProductEntity(product.id))
    }
    fun existById(product: Product):Boolean{
        return productDao.getById(product.id)!=null;
    }
}