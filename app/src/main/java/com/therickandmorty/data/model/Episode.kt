package com.therickandmorty.data.model

data class Episode(
    val air_date: String,
    val characters: List<Character>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)