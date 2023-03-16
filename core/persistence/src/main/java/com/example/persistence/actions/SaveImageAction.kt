package com.example.persistence.actions

import com.example.domain.actions.Action
import com.example.persistence.dao.ImagesDao
import com.example.persistence.entity.ImageEntity
import javax.inject.Inject


//Action to add image to Image table
class SaveImageAction @Inject constructor(
    private val imagesDao: ImagesDao
) : Action<ImageEntity,Unit>() {

    override suspend fun action(input: ImageEntity) {
        imagesDao.saveImage(input)
    }
}
