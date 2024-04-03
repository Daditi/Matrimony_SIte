package com.example.myapplication.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.FilterTextColor
import com.example.myapplication.ui.theme.SearchBarBackground
import com.example.myapplication.ui.theme.SearchTextColor
import com.example.myapplication.ui.theme.TopBarBackground

@Composable
fun TopBarComposable() {
    Column(
        modifier = Modifier
            .background(TopBarBackground)
            .padding(top = 24.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Explore",
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
            )
            Text(
                text = "Filter",
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = FilterTextColor
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(SearchBarBackground, RoundedCornerShape(50))
                .padding(16.dp),
            text = "Search",
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            color = SearchTextColor
        )
    }
}