package com.therickandmorty.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.therickandmorty.data.repository.EpisodesRepository

class EpisodesViewModelFactory(
    private val episodesRepository: EpisodesRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(EpisodesViewModel::class.java) ->
                EpisodesViewModel(episodesRepository) as T
            else -> throw IllegalArgumentException("Not found")
        }
    }
}