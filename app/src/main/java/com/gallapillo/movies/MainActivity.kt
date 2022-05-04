package com.gallapillo.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gallapillo.movies.common.Constants
import com.gallapillo.movies.common.Screens
import com.gallapillo.movies.presentation.movie_list.MovieListScreen
import com.gallapillo.movies.presentation.splash.SplashScreen
import com.gallapillo.movies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Constants.SPLASH_SCREEN_ROUTE
                ) {
                    composable(route = Screens.Splash.route) {
                        SplashScreen(navController)
                    }
                    composable(route = Screens.MovieList.route) {
                        MovieListScreen()
                    }
                    composable(route = Screens.Detail.route) {

                    }
                }
            }
        }
    }
}
