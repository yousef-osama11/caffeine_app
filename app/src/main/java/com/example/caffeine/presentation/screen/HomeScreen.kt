package com.example.caffeine.presentation.screen

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.example.caffeine.CoffeeSelectionScreen
import com.example.caffeine.R
import com.example.caffeine.Screen
import com.example.caffeine.presentation.component.CaffeineButton
import com.example.caffeine.presentation.component.HomeAppBar
import com.example.caffeine.presentation.component.HomeIntroText

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        Modifier
            .padding(horizontal = 12.dp)
            .padding(top = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        val infiniteTransition = rememberInfiniteTransition()

        HomeAppBar(onClickButton = {})
        Box(modifier = Modifier.wrapContentSize()) {
            Box(
                modifier = Modifier
                    .width(188.dp)
                    .height(200.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    HomeIntroText("Hocus")
                    HomeIntroText("Pocus")
                    HomeIntroText("I Need Coffee ")
                    HomeIntroText("to Focus")
                }
            }

            val currentStarColor by infiniteTransition.animateColor(
                initialValue = Color(0x1F1F1FDE).copy(alpha = 0.87f),
                targetValue = Color(0x1F1F1FDE).copy(alpha = 0.2f),
                animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = 2000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Image(
                painter = painterResource(R.drawable.home_star),
                contentDescription = "star icon",
                modifier = Modifier.padding(start = 10.dp, top = 65.dp),
                colorFilter = ColorFilter.tint(currentStarColor)
            )
            Image(
                painter = painterResource(R.drawable.home_star),
                contentDescription = "star icon",
                modifier = Modifier.padding(start = 173.dp, top = 6.dp),
                colorFilter = ColorFilter.tint(currentStarColor)
            )
            Image(
                painter = painterResource(R.drawable.home_star),
                contentDescription = "star icon",
                modifier = Modifier.padding(start = 190.dp, top = 190.dp, bottom = 31.dp),
                colorFilter = ColorFilter.tint(currentStarColor)
            )
        }
        val ghostOffset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = -35f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val shadowOffset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 25f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 2000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        Image(painterResource(R.drawable.ghost_coffee), contentDescription = "ghost coffee",Modifier.offset(y= ghostOffset.dp))
        Image(painterResource(R.drawable.ellipse_92), contentDescription = "shadow",Modifier.offset(y= shadowOffset.dp))
        Spacer(modifier = Modifier.weight(1f))
        CaffeineButton(
            text = "bring my coffee",
            imageId = R.drawable.coffee_02,
            onClick = { navController.navigate(CoffeeSelectionScreen(name = "joe" , age = "20")) },
            modifier = Modifier.padding(bottom = 50.dp)
        )

    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun PreviewHomeScreen() {
//    HomeScreen()
//}