package com.example.network.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleDi {

    @Provides
    @Singleton
    fun provideKtorClient(@ApplicationContext appContext: Context): HttpClient =
        HttpClient(Android) {
            // Logging
            install(Logging)
            // JSON
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to all requests
            defaultRequest {
                accept(ContentType.Application.Json)
            }
        }
}