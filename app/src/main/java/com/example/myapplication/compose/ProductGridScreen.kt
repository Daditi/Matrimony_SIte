package com.example.myapplication.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.model.Product
import com.example.myapplication.ui.theme.SearchBarBackground
import com.example.myapplication.viewmodel.HomeViewModel

const val COLUMN_COUNT = 3

@Composable
fun ProductGridScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val productList = viewModel.productList.collectAsState().value
    LazyVerticalGrid(
        columns = GridCells.Fixed(COLUMN_COUNT),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(productList) {
            ProductGridItem(it)

        }
    }
}
@Composable
internal fun ProductGridItem(product: Product) {
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "ProductGridImage",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(110.dp)
                .background(SearchBarBackground, RoundedCornerShape(8.dp))
        )
        Text(
            text = product.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
        )
        Text(
            text = "₹${product.price}",
            fontSize = 14.sp,
            fontWeight = FontWeight.W600,
        )
    }
}