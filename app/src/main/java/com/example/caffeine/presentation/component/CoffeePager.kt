package com.example.caffeine.presentation.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun DrawablePager(
    modifier: Modifier = Modifier,
    onCoffeeSelected: (String) -> Unit = {}
) {
    val drawables = listOf(
        R.drawable.coffee_black,
        R.drawable.latte,
        R.drawable.macchiato,
        R.drawable.espresso
    )

    val pagerState = rememberPagerState(pageCount = { drawables.size })

    LaunchedEffect(pagerState.currentPage) {
        val selectedCoffee = mapImageIdToString(drawables[pagerState.currentPage])
        onCoffeeSelected(selectedCoffee)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(298.dp),
            reverseLayout = true,
            contentPadding = PaddingValues(horizontal = 80.dp),
            pageSpacing = 10.dp,
        ) { page ->

            val coffeeSizeWidth by animateFloatAsState(
                if (pagerState.currentPage == page) 199f else 119f,
                animationSpec = tween(400)
            )
            val coffeeSizeHeight by animateFloatAsState(
                if (pagerState.currentPage == page) 298f else 204f,
                animationSpec = tween(400)
            )
            val coffeeOffsetY by animateFloatAsState(
                if (pagerState.currentPage == page) 0f else 30f,
                animationSpec = tween(400)
            )


            Image(
                painter = painterResource(id = drawables[page]),
                contentDescription = "Image $page",
                modifier = Modifier
                    .width(coffeeSizeWidth.dp)
                    .height(coffeeSizeHeight.dp)
                    .offset(x = -20.dp, y = coffeeOffsetY.dp)
            )
        }

    }
}

fun mapImageIdToString(id: Int): String {
    return when (id) {
        R.drawable.coffee_black -> "Black"
        R.drawable.latte -> "latte"
        R.drawable.macchiato -> "macchiato"
        R.drawable.espresso -> "espresso"
        else -> "latte"
    }
}

@Preview
@Composable
fun PreviewPager() {
    DrawablePager()
}