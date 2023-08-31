package com.ekaterinabaygin.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video")
data class Video(
    @PrimaryKey val id: Int,
    val name: String,
    val snapshot: String,
    val room: String?,
    val type: String,
    val favorites: Boolean,
    val rec: Boolean
)
