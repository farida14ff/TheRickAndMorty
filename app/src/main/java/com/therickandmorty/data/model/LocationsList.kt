package com.therickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class LocationsList(
    val info: InfoXX,
    @SerializedName("results")
    val locationResults: List<LocationResult>
)