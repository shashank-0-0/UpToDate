package com.example.persistence.actions

import com.example.domain.actions.SharedFlowAction
import com.example.domain.dataModel.Image
import com.example.persistence.dao.ImagesDao
import com.example.persistence.entity.ImageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @return a flow of latest Images in the database
 */
@Singleton
class ImagesFlow @Inject constructor(
    private val imagesDao: ImagesDao,
) : SharedFlowAction<List<Image>>() {
    init {
        println("shetty y $imagesDao")
    }

    override fun initialValue(): List<Image> = emptyList()

    override fun createFlow(): Flow<List<Image>> =
        imagesDao.getImages()
            .map { imageEntities ->
                imageEntities.map { imageEntity ->
                    Image(
                        date = "", //no need of date ,it has to be removed
                        explanation = imageEntity.explanation,
                        title = imageEntity.title,
                        url = imageEntity.url
                    )
                }
            }
            .flowOn(Dispatchers.Default)
}
