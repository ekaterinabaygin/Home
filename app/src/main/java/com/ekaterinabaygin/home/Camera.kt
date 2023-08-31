package com.ekaterinabaygin.home

import com.google.gson.annotations.SerializedName

data class Camera(
    @SerializedName("name")
    val name: String,
    @SerializedName("snapshot")
    val snapshot: String,
    @SerializedName("room")
    val room: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("favourites")
    val favorites: Boolean,
    @SerializedName("rec")
    val rec: Boolean
)

