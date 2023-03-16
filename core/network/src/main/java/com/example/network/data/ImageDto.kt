package com.example.network.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    @SerialName("copyright")
    val copyright: String?=null,
    @SerialName("date")
    val date: String,
    @SerialName("explanation")
    val explanation: String,
    @SerialName("hdurl")
    val hdurl: String?=null,
    @SerialName("media_type")
    val media_type: String,
    @SerialName("service_version")
    val service_version: String,
    @SerialName("title")
    val title: String,
    @SerialName("url")
    val url: String
)