package com.example.favourites

//All the events originating from favorites screen
sealed interface FavouritesEvent{
    object onHomeClick:FavouritesEvent
}