package com.therickandmorty.data.model

data class LocationResult(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<Any>,
    val type: String,
    val url: String
){
    override fun toString(): String {
        return "LocationResult(created='$created', dimension='$dimension', id=$id, name='$name', residents=$residents, type='$type', url='$url')"
    }
}