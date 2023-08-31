package com.ekaterinabaygin.home

import Door
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
