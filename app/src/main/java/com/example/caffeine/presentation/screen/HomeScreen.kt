package com.example.caffeine.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.presentation.component.CaffeineButton
import com.example.caffeine.presentation.component.HomeAppBar
import com.example.caffeine.presentation.component.HomeIntroText
import com.example.caffeine.ui.theme.singlet

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .padding(horizontal = 12.dp)
            .padding(top = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeAppBar(onClickButton = {})
        Box(modifier = Modifier.wrapContentSize()){
            Box(modifier = Modifier
                .width(188.dp)
                .height(200.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    HomeIntroText("Hocus")
                    HomeIntroText("Pocus")
                    HomeIntroText("I Need Coffee ")
                    HomeIntroText("to Focus")
                }
            }
            Image(painter = painterResource(R.drawable.home_star), contentDescription = "star icon", modifier = Modifier.padding(start = 10.dp, top = 65.dp))
            Image(painter = painterResource(R.drawable.home_star), contentDescription = "star icon", modifier = Modifier.padding(start = 173.dp,top = 6.dp))
            Image(painter = painterResource(R.drawable.home_star), contentDescription = "star icon", modifier = Modifier.padding(start = 190.dp, top = 190.dp, bottom = 31.dp))
        }
        Image(painterResource(R.drawable.ghost_coffee), contentDescription = "ghost coffee")
        Image(painterResource(R.drawable.ellipse_92), contentDescription = "shadow")
        Spacer(modifier = Modifier.weight(1f))
        CaffeineButton(text = "bring my coffee", imageId = R.drawable.coffee_02, onClick = {}, modifier = Modifier.padding(bottom = 50.dp))

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}