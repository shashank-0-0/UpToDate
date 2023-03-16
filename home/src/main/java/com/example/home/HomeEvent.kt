package com.example.home

sealed interface HomeEvent{
    object LoadMoreImages:HomeEvent
    object FavoritesClick:HomeEvent
    object SaveImage:HomeEvent
}
