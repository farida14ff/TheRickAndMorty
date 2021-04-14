package com.therickandmorty.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.therickandmorty.data.repository.LocationRepository

class LocationViewModelFactory(
private val locationRepository: LocationRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LocationViewModel::class.java) ->
                LocationViewModel(locationRepository) as T
            else -> throw IllegalArgumentException("Not found")
        }
    }
}