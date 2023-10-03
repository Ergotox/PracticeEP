package com.example.practiceep.ui.explorer.activities.browser

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.practiceep.data.local.AppDatabase
import com.example.practiceep.data.model.Product
import com.example.practiceep.repository.ProductRepository
import com.example.practiceep.ui.explorer.components.ProductList
import com.example.practiceep.ui.explorer.components.info.ErrorMessage
import com.example.practiceep.utils.Result
import com.example.practiceep.ui.explorer.components.SearchBar
import com.example.practiceep.ui.explorer.components.info.Waiting

@Composable
fun ProductBrowser(){
    val context = LocalContext.current
    val(searchTerm, setSearchTerm) = remember{ mutableStateOf("") }
    val(products, setProducts) = remember { mutableStateOf<List<Product>?>(listOf<Product>())}
    val (isLoading, setIsLoading) = remember { mutableStateOf(false)}
    val productDao = AppDatabase.getInstance(context).productDao()
    val productRepository = ProductRepository(productDao = productDao)

    LaunchedEffect(searchTerm){
        setIsLoading(true)
        productRepository.searchByName(searchTerm){ result ->
            if (result is Result.Success){
                result.data!!.forEach{product ->
                    product.isFavorite = productRepository.existById(product)
                }
                setProducts(result.data!!)
            }
            else{
                setProducts(null)
            }
            setIsLoading(false)
        }
    }
    if(products == null){
        ErrorMessage()
        return
    }
    Column {
        SearchBar(setSearchTerm)
        if(searchTerm.isEmpty()){
            Waiting()
            return
        }
        if(isLoading){
            return
        }
        ProductList(products)
    }
}