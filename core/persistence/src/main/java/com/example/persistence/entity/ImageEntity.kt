package com.example.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Image")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "explanation")
    val explanation: String,
    @ColumnInfo(name="title")
    val title: String,
    @ColumnInfo(name="url")
    val url: String
)