package com.therickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class CharactersList(
    val info: Info,
    @SerializedName("results")
    val characters: List<Character>
)