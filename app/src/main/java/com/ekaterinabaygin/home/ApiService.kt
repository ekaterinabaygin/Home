package com.ekaterinabaygin.home

import Door
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameraList(): List<Camera>

    @GET("doors/")
    suspend fun getDoorList(): List<Door>
}
