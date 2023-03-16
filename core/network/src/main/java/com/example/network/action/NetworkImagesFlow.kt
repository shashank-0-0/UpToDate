package com.example.network.action

import com.example.domain.actions.FlowAction
import com.example.domain.dataModel.Image
import com.example.network.data.ImageDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NetworkImagesFlow @Inject constructor(
    private val ktorClient: HttpClient,
) : FlowAction<Unit, List<Image>>() {

    override fun createFlow(input: Unit): Flow<List<Image>> = flow {
        emit(fetchImages(input))
    }

    private suspend fun fetchImages(input: Unit): List<Image> {
        return try {
            ktorClient.get<List<ImageDto>> {
                url("https://api.nasa.gov/planetary/apod")
                parameter("api_key", "DEMO_KEY")
                parameter("count", "10")
            }.map {
                toImage(it)
            }
        } catch (ex: Exception) {
            println("shetty ex :${ex.localizedMessage}")
            emptyList()
        }
    }

    private fun toImage(imageDto: ImageDto) = Image(
        date = imageDto.date,
        explanation = imageDto.explanation,
        title = imageDto.title,
        url = imageDto.url
    )
}