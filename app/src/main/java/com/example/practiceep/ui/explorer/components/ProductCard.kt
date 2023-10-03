package com.example.practiceep.ui.explorer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practiceep.data.local.AppDatabase
import com.example.practiceep.data.model.Product
import com.example.practiceep.repository.ProductRepository
import com.example.practiceep.ui.navigation.Routes
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun ProductCard(product: Product) {
    val context = LocalContext.current
    val (isFavorite, setIsFavorite) = remember { mutableStateOf(product.isFavorite) }
    val productDao = AppDatabase.getInstance(context).productDao()
    val productRepository = ProductRepository(productDao = productDao)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            GlideImage(
                imageModel = { product.image.url },
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier.size(112.dp)
            )
            Column(modifier = Modifier.weight(5f)) {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = product.name, fontWeight = FontWeight.Bold)
            }
            IconButton(modifier = Modifier.weight(1f), onClick = {
                if (isFavorite) {
                    product.isFavorite = false
                    productRepository.delete(product)
                } else {
                    product.isFavorite = true
                    productRepository.save(product)
                }
                setIsFavorite(!isFavorite)
            }) {
                Icon(
                    Icons.Default.Favorite,
                    "Favorite Icon",
                    tint =
                    if (isFavorite) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }

}