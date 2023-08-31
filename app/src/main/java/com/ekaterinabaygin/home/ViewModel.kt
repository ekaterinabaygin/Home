package com.ekaterinabaygin.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ekaterinabaygin.home.repository.Repository
import kotlinx.coroutines.launch

class VideoViewModel(private val repository: Repository) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.refreshVideos()
        }
    }

}

class VideoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoViewModel::class.java)) {
            val database = VideosDatabase.getInstance(application)
            val repository = Repository(database)
            return VideoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
