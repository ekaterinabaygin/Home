package com.ekaterinabaygin.home

import androidx.room.*

@Dao
interface VideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(videos: List<Video>)

    @Query("SELECT * FROM video")
    suspend fun getAllVideos(): List<Video>

    @Query("SELECT * FROM video WHERE type = :type")
    suspend fun getVideosByType(type: String): List<Video>

    @Query("UPDATE video SET name = :newName WHERE id = :videoId")
    suspend fun updateVideoName(videoId: Int, newName: String)
}
