package com.ekaterinabaygin.home.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekaterinabaygin.home.entity.Video
import com.ekaterinabaygin.home.repository.GetVideosUseCase
import com.ekaterinabaygin.home.repository.RefreshVideosUseCase
import com.ekaterinabaygin.home.repository.UpdateVideoNameUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class VideoViewModel(
    private val getVideosUseCase: GetVideosUseCase,
    private val refreshVideosUseCase: RefreshVideosUseCase,
    private val updateVideoNameUseCase: UpdateVideoNameUseCase
) : ViewModel() {

    private val _videosLiveData = MutableStateFlow<List<Video>>(emptyList())
    val videosLiveData: StateFlow<List<Video>> = _videosLiveData.asStateFlow()

    init {
        loadVideos()
    }

    private fun loadVideos() {
        viewModelScope.launch {
            getVideosUseCase
                .onStart {
                    Log.d(TAG, "Flow started")
                }
                .catch { exception ->
                    Log.e(TAG, "Flow error: $exception")
                }
                .collect { videos ->
                    _videosLiveData.value = videos
                }
        }
    }

    fun refreshData() {
        viewModelScope.launch {
            refreshVideosUseCase.execute()
        }
    }

    fun updateVideoName(videoId: String, newName: String) {
        viewModelScope.launch {
            updateVideoNameUseCase.updateVideoName(videoId, newName)
        }
    }
}
