package com.example.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistence.dao.ImagesDao
import com.example.persistence.entity.ImageEntity

@Database(entities = [ImageEntity::class], version = 1)
abstract class CoreDb : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao

    companion object {
        private const val DB_NAME = "coreDb"

        fun create(applicationContext: Context): CoreDb {
            return Room.databaseBuilder(
                applicationContext,
                CoreDb::class.java,
                DB_NAME
            ).build()
        }
    }
}