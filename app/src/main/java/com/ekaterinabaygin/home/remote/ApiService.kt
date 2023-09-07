package com.ekaterinabaygin.home.remote

import com.ekaterinabaygin.home.entity.Door
import com.ekaterinabaygin.home.entity.Camera
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameraList(): List<Camera>

    @GET("doors/")
    suspend fun getDoorList(): List<Door>
}
