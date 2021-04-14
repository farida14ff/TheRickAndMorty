package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.apiCall
import com.therickandmorty.data.model.LocationsList
import com.therickandmorty.data.remote.TheRickAndMortyClient

class LocationRepositoryImpl(
    private val theRickAndMortyClient: TheRickAndMortyClient
):LocationRepository {

    override suspend fun getLocationList(): ApiResult<LocationsList> {
        return apiCall { theRickAndMortyClient.getLocationsList() }
    }
}