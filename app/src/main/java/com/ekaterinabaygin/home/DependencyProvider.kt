package com.ekaterinabaygin.home

import GetVideosUseCaseImpl
import RefreshVideosUseCaseImpl
import UpdateVideoNameUseCaseImpl
import android.content.Context
import com.ekaterinabaygin.home.dataBase.VideosDatabase
import com.ekaterinabaygin.home.repository.RefreshVideosUseCase
import com.ekaterinabaygin.home.repository.Repository
import com.ekaterinabaygin.home.repository.UpdateVideoNameUseCase
import com.ekaterinabaygin.home.repository.GetVideosUseCase

object DependencyProvider {

    private lateinit var applicationContext: Context

    fun initialize(context: Context) {
        applicationContext = context.applicationContext
    }

    private val database by lazy { VideosDatabase.getInstance(applicationContext) }
    private val repository by lazy { Repository(database) }

    fun provideRefreshVideosUseCase(): RefreshVideosUseCase {
        return RefreshVideosUseCaseImpl(repository)
    }

    fun provideUpdateVideoNameUseCase(): UpdateVideoNameUseCase {
        return UpdateVideoNameUseCaseImpl(repository)
    }

    fun provideGetVideosUseCase(): GetVideosUseCase {
        return GetVideosUseCaseImpl(repository)
    }
}
