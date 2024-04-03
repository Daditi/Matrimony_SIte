package com.example.myapplication.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.myapplication.model.Product
import com.example.myapplication.ui.theme.BottomBarUnselected
import com.example.myapplication.ui.theme.SearchBarBackground
import com.example.myapplication.ui.theme.neutralTextColor
import com.example.myapplication.viewmodel.HomeViewModel

@Composable
fun ProductListScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val productList = viewModel.productList.collectAsState().value
    LazyColumn(
        contentPadding = PaddingValues(vertical = 32.dp, horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productList) {
            ProductListItem(it)
        }
    }
}

@Composable
internal fun ProductListItem(product: Product) {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "ProductListImage",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(50.dp)
                .background(SearchBarBackground, RoundedCornerShape(8.dp))
        )
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = product.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            SpanStyle(color = neutralTextColor)
                        ) { append("MRP: ") }
                        append("₹${product.price}")
                    },
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                )
                Text(
                    text = product.deliveryTag,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    color = neutralTextColor
                )
            }
            Divider(
                color = BottomBarUnselected,
                thickness = 1.dp
            )
        }
    }
}