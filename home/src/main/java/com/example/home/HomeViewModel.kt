package com.example.home

import androidx.lifecycle.viewModelScope
import com.example.domain.SimpleFlowViewModel
import com.example.domain.dataModel.Image
import com.example.navigation.Navigator
import com.example.navigation.destinations.Destination
import com.example.network.action.NetworkImagesFlow
import com.example.persistence.actions.SaveImageAction
import com.example.persistence.entity.ImageEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkImagesFlow: NetworkImagesFlow,
    private val navigator: Navigator,
    private val saveImageAction : SaveImageAction
) : SimpleFlowViewModel<HomeState, HomeEvent>() {

    init{
        viewModelScope.launch {
        }
    }
    override val initialUi: HomeState = HomeState(
        loading = true,
        images = emptyList()
    )
    private val moreImages = MutableStateFlow<List<Image>>(emptyList())

    override val uiFlow: Flow<HomeState> = combine(
        networkImagesFlow(Unit), moreImages
    ) { images, moreImages ->
        println("shetty ${images.size} ${moreImages.size}")
        HomeState(
            loading = false,
            images = if(moreImages.isNotEmpty()) uiState.value.images+moreImages else images
        )
    }

    override suspend fun handleEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadMoreImages -> moreImages()
            is HomeEvent.FavoritesClick -> handleFavoitesClick()
            is HomeEvent.SaveImage -> handleSaveImage()
        }
    }

    private  suspend fun moreImages() {
        val newImages = networkImagesFlow(Unit).single()
        moreImages.value =  newImages
    }
    private fun handleFavoitesClick(){
        navigator.navigate(Destination.favorites.route)
    }
    private suspend fun handleSaveImage(){

    }

}
