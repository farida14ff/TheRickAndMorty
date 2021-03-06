package com.therickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class EpisodesList(
    val info: InfoX,
    @SerializedName("results")
    val episodes: List<Episode>
)