package com.ekaterinabaygin.home.repository

import com.ekaterinabaygin.home.entity.Video
import kotlinx.coroutines.flow.Flow

class RefreshVideosUseCaseImpl(
    private val repository: Repository
) : RefreshVideosUseCase {
    override suspend fun execute() {
        repository.refreshVideos()
    }
}

class UpdateVideoNameUseCaseImpl(
    private val repository: Repository
) : UpdateVideoNameUseCase {
    override suspend fun updateVideoName(videoId: String, newName: String) {
        repository.updateVideoName(videoId, newName)
    }
}

class GetVideosUseCaseImpl(
    private val repository: Repository
) : GetVideosUseCase {
    fun execute(): Flow<List<Video>> {
        return repository.getVideosUseCase()
    }


}

