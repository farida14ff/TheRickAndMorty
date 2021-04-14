package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.LocationsList

interface LocationRepository {

    suspend fun getLocationList(): ApiResult<LocationsList>

}