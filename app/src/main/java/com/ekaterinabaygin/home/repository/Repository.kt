package com.ekaterinabaygin.home.repository

import com.ekaterinabaygin.home.dataBase.VideosDatabase
import com.ekaterinabaygin.home.entity.Video
import com.ekaterinabaygin.home.remote.GetVideoRemote
import kotlinx.coroutines.flow.Flow

class Repository(private val database: VideosDatabase) {

    suspend fun refreshVideos() {
        val cameras = GetVideoRemote.getCameraList()
        val doors = GetVideoRemote.getDoorList()
        val videoList = mutableListOf<Video>()

        cameras.forEach { camera ->
            videoList.add(
                Video(
                    id = camera.id,
                    name = camera.name,
                    snapshot = camera.snapshot,
                    room = camera.room,
                    type = "camera",
                    favorites = camera.favorites,
                    rec = camera.rec
                )
            )
        }

        doors.forEach { door ->
            videoList.add(
                Video(
                    id = door.id,
                    name = door.name,
                    snapshot = door.snapshot,
                    room = door.room,
                    type = "door",
                    favorites = door.favorites,
                    rec = door.rec
                )
            )
        }

        database.videoDao.insertAll(videoList)
    }

    suspend fun updateVideoName(videoId: String, newName: String) {
        database.videoDao.updateVideoName(videoId, newName)
    }

//    fun getVideos(): Flow<List<Video>> {
//        return database.videoDao.getAllVideos()
//    }

     fun getVideosUseCase(): Flow<List<Video>> {
         return database.videoDao.getAllVideos()
    }
}