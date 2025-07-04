package com.example.caffeine.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.CustomizeCoffeeScreen
import com.example.caffeine.R
import com.example.caffeine.presentation.component.CaffeineButton
import com.example.caffeine.presentation.component.DrawablePager
import com.example.caffeine.presentation.component.HomeAppBar
import com.example.caffeine.ui.theme.urbanist
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeeSelectionScreen(
    navController: NavController,
    viewModel: CoffeeSelectionViewModel = koinViewModel()
) {

    val state by viewModel.state.collectAsState()

    var selectedCoffee by remember { mutableStateOf("Latte") }


    Box() {
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
                text = "${state.name},${state.age} ☀",
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
                modifier = Modifier.padding(bottom = 56.dp)
            )

            Spacer(modifier = Modifier.weight(1f))
            CaffeineButton(
                text = "Continue",
                imageId = R.drawable.arrow_right_04,
                onClick = {
                    navController.navigate(CustomizeCoffeeScreen(name = selectedCoffee))
                },
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .align(Alignment.CenterHorizontally)
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(100.dp))
            )
        }
        DrawablePager(modifier = Modifier.padding(top = 285.dp),
            onCoffeeSelected = { coffeeName ->
                selectedCoffee = coffeeName // Update selected coffee when user swipes
            })


    }
}

fun onClickNext(state: String, navController: NavController) {
    navController.navigate(CustomizeCoffeeScreen(name = state))
}
