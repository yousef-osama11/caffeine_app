package com.example.caffeine.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.singlet
import com.example.caffeine.ui.theme.urbanist

@Composable
fun CoffeeSelectionScreen() {
    Column(
        Modifier
            .padding(horizontal = 12.dp)
            .padding(top = 56.dp),
    ) {
        HomeAppBar(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = "Good Morning",
            fontSize = 36.sp,
            fontWeight = FontWeight(700),
            fontFamily = urbanist,
            color = Color(0xFFB3B3B3),
        )
        Text(
            text = "Hamsa ☀",
            fontSize = 36.sp,
            fontWeight = FontWeight(700),
            fontFamily = urbanist,
            color = Color(0xFF3B3B3B),
        )
        Text(
            text = "What would you like to drink today?",
            fontSize = 16.sp,
            fontWeight = FontWeight(700),
            fontFamily = urbanist,
            color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCoffeeSelectionScreen() {
    CoffeeSelectionScreen()
}