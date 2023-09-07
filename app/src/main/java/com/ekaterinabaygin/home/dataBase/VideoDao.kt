package com.ekaterinabaygin.home.dataBase

import androidx.room.*
import com.ekaterinabaygin.home.entity.Video
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(videos: List<Video>)

    @Query("SELECT * FROM video")
    fun getAllVideos(): Flow<List<Video>>

    @Query("SELECT * FROM video WHERE type = :type")
    fun getVideosByType(type: String): Flow<List<Video>>

    @Query("UPDATE video SET name = :newName WHERE id = :videoId")
    suspend fun updateVideoName(videoId: String, newName: String)
}
