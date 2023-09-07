package com.ekaterinabaygin.home.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ekaterinabaygin.home.entity.Camera
import com.ekaterinabaygin.home.entity.Door

@Database(entities = [Camera::class, Door::class], version = 1, exportSchema = false)
abstract class VideosDatabase : RoomDatabase() {

    abstract val videoDao: VideoDao

    companion object {

        @Volatile
        private var INSTANCE: VideosDatabase? = null

        fun getInstance(context: Context): VideosDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        VideosDatabase::class.java,
                        "videos_database"
                    ).build()
                }
                return instance
            }
        }
    }
}
