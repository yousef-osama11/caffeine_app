package com.example.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.urbanist

@Composable
fun CaffeineButton(modifier: Modifier = Modifier,text: String, imageId: Int,onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(
                RoundedCornerShape(100.dp)
            )
            .background(color = Color(0xFF1F1F1F)).clickable { onClick() }
    ) {
        Text(
            text = text,
            fontWeight = FontWeight(700),
            color = Color.White.copy(alpha = 0.87f),
            fontSize = 16.sp,
            fontFamily = urbanist,
            modifier = Modifier.padding(
                start = 32.dp,
                top = 18.5.dp,
                bottom = 18.5.dp,
                end = 9.13.dp
            )
        )
        Image(painterResource(imageId), contentDescription = null, Modifier.padding(end = 32.dp))
    }
}

@Preview
@Composable
fun PreviewCaffeineButton() {
    CaffeineButton(text = "bring my coffee", imageId = R.drawable.coffee_02, onClick = {})
}