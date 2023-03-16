package com.example.home

import com.example.domain.dataModel.Image

data class HomeState(
    val loading:Boolean,
    val images:List<Image>
)