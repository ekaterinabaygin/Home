package com.ekaterinabaygin.home.repository

interface UpdateVideoNameUseCase {
    suspend fun updateVideoName(videoId: String, newName: String)
}
