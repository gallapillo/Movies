package com.gallapillo.movies.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gallapillo.movies.common.Screens
import com.gallapillo.movies.presentation.movie_list.MovieListViewModel
import com.gallapillo.movies.presentation.theme.BackGround
import com.gallapillo.movies.presentation.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    var startAnimate by remember {
        mutableStateOf(false)
    }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimate) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimate = true
        delay(4000)
        navController.navigate(Screens.MovieList.route)
    }
    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(
    alpha: Float
) {
    Box(
        modifier = Modifier.fillMaxSize().background(BackGround),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha),
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "",
            tint = Primary
        )
    }
}