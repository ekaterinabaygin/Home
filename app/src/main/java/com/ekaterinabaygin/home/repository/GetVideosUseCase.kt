package com.ekaterinabaygin.home.repository

import com.ekaterinabaygin.home.entity.Video
import kotlinx.coroutines.flow.Flow

interface GetVideosUseCase : Flow<List<Video>>


