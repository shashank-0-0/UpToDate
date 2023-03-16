package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.destinations.Destination
import com.example.navigation.destinations.Favorites
import com.example.navigation.destinations.Home
import kotlinx.coroutines.flow.collectLatest


@Composable
fun NavigationRoot(
    navigator: Navigator,
    home: @Composable () -> Unit,
    favorites: @Composable () -> Unit
) {
    val navController = rememberNavController()
    LaunchedEffect(Unit) {
        navigator.actions.collectLatest { action ->
            when (action) {
                Navigator.Action.Back -> navController.popBackStack()
                is Navigator.Action.Navigate -> navController.navigate(
                    route = action.destination,
                    builder = action.navOptions
                )
            }
        }
    }
    NavHost(
        navController = navController,
        startDestination = Destination.home.route
    ) {
        composable(Home.route) {
            home()
        }
        composable(Favorites.route){
            favorites()
        }
    }
}