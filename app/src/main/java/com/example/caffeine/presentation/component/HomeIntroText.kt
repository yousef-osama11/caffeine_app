package com.example.caffeine.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.caffeine.ui.theme.singlet

@Composable
fun HomeIntroText(text: String){
    Text(
        text = text,
        fontSize = 32.sp,
        fontWeight = FontWeight(400),
        fontFamily = singlet,
        color = Color(0xFF1F1F1F).copy(alpha = 0.87f),
        lineHeight = 50.sp,
    )
}