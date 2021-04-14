package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.EpisodesList

interface EpisodesRepository {

    suspend fun getEpisodesList(): ApiResult<EpisodesList>

}