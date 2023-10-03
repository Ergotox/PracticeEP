package com.example.practiceep.ui.explorer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practiceep.data.model.Product
import com.example.practiceep.ui.explorer.components.info.NoSearchResults

@Composable
fun ProductList(products: List<Product>) {
    if (products.isEmpty()) {
        NoSearchResults()
        return
    }

    Column (modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Search results (${products.size}):",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn {
            items(products) {
                    product -> ProductCard(product = product)
            }
        }
    }
}
