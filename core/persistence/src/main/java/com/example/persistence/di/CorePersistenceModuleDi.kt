package com.example.persistence.di

import android.content.Context
import com.example.persistence.CoreDb
import com.example.persistence.dao.ImagesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CorePersistenceModuleDI {

    @Provides
    @Singleton
    fun provideCoreDb(@ApplicationContext appContext: Context): CoreDb =
        CoreDb.create(appContext)

    @Provides
    @Singleton
    fun provideAccountDao(db: CoreDb): ImagesDao = db.imagesDao()

}