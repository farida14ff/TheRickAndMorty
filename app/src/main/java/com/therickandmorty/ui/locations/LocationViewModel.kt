package com.therickandmorty.ui.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.Location
import com.therickandmorty.data.model.LocationsList
import com.therickandmorty.data.repository.LocationRepository

class LocationViewModel (
    private val locationRepository: LocationRepository
) : ViewModel() {


    val whether = liveData {
        emit(ApiResult.Loading)
        val result = locationRepository.getLocationList()
        emit(result)
    }
}