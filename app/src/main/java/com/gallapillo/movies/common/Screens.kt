package com.gallapillo.movies.common

sealed class Screens(val route: String) {
   object Splash: Screens(Constants.SPLASH_SCREEN_ROUTE)
   object MovieList: Screens(Constants.MOVIE_LIST_SCREEN_ROUTE)
   object Detail: Screens(Constants.DETAILS_SCREEN_ROUTE)
}
