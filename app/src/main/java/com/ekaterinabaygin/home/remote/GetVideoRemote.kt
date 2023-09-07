package com.ekaterinabaygin.home.remote

import com.ekaterinabaygin.home.entity.Door
import com.ekaterinabaygin.home.entity.Camera
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetVideoRemote {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://cars.cprogroup.ru/api/rubetek/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ApiService::class.java)

    suspend fun getCameraList(): List<Camera> {
        return service.getCameraList()
    }

    suspend fun getDoorList(): List<Door> {
        return service.getDoorList()
    }
}
