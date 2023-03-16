package com.example.favourites

import com.example.domain.dataModel.Image

data class FavoritesState(
    val loading:Boolean,
    val images:List<Image>
)
