package com.example.favourites

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bottom_bar.BottomBar
import com.example.bottom_bar.Tab


@Composable
fun BoxScope.FavoritesScreen() {
    val viewModel: FavoritesViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsState()

    UI(
        state = state,
        onEvent = viewModel::onEvent,
    )

}

@Composable
private fun BoxScope.UI(
    state: FavoritesState,
    onEvent: (FavouritesEvent) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text("Welcome to Favorites Screen ${state.images.size}")
    }

    BottomBar(
        selectedTab = Tab.Favorites,
        onHomeClick = {
            onEvent(FavouritesEvent.onHomeClick)
        },
        onFavoritesClick = {
        }
    )

}