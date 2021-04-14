package com.therickandmorty.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.repository.EpisodesRepository

class EpisodesViewModel(
    private val episodesRepository: EpisodesRepository
) : ViewModel() {

    val episode = liveData{
        emit(ApiResult.Loading)
        val result = episodesRepository.getEpisodesList()
        emit(result)
    }
}