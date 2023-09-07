package com.ekaterinabaygin.home.entity


data class Camera(
    val name: String,
    val snapshot: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val rec: Boolean
)

