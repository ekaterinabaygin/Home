package com.ekaterinabaygin.home.repository

import com.ekaterinabaygin.home.ApiClient
import com.ekaterinabaygin.home.Video
import com.ekaterinabaygin.home.VideosDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: VideosDatabase) {

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val cameras = ApiClient.getCameraList()
            val doors = ApiClient.getDoorList()
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

            database.VideoDao.insertAll(videoList)


            suspend fun updateVideoName(videoId: String, newName: String) {
                withContext(Dispatchers.IO) {
                    database.videoDao.updateVideoName(videoId, newName)
                }
            }

            suspend fun getVideos(): List<Video> {
                return withContext(Dispatchers.IO) {
                    val videosFromDb = database.videoDao.getAllVideos()
                    if (videosFromDb.isEmpty()) {
                        refreshVideos()
                        database.videoDao.getAllVideos()
                    } else {
                        videosFromDb
                    }
                }
            }
        }
