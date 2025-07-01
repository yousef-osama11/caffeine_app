package com.example.caffeine.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun HomeAppBar(onClickButton: () -> Unit = {}){
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(R.drawable.ghost_profile), contentDescription = "profile icon")
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.clip(CircleShape).background(color = Color(0xFFF5F5F5)).clickable { onClickButton() }, contentAlignment = Alignment.Center){
            Image(painter = painterResource(R.drawable.add_01), contentDescription = "add icon", modifier = Modifier.padding(12.dp))
        }
    }
}

@Preview
@Composable
fun PreviewHomeAppBar(){
    HomeAppBar()
}