package com.example.favourites

import com.example.domain.SimpleFlowViewModel
import com.example.navigation.Navigator
import com.example.navigation.destinations.Destination
import com.example.persistence.actions.ImagesFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val imagesFlow: ImagesFlow,
    private val navigator: Navigator
) : SimpleFlowViewModel<FavoritesState, FavouritesEvent>() {

    override val initialUi: FavoritesState = FavoritesState(
        loading = true,
        images = emptyList()
    )

    override val uiFlow: Flow<FavoritesState> = imagesFlow().map {
        FavoritesState(
            loading = false,
            images = it
        )
    }

    override suspend fun handleEvent(event: FavouritesEvent) {
        when(event){
            is FavouritesEvent.onHomeClick -> handleHomeCLick()
        }
    }
    private fun handleHomeCLick(){
        navigator.navigate(Destination.home.route){
            popUpTo(Destination.home.route){
                inclusive=true
            }
        }
    }
}
