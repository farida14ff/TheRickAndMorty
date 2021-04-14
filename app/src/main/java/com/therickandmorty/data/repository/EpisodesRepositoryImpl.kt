package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.apiCall
import com.therickandmorty.data.model.EpisodesList
import com.therickandmorty.data.remote.TheRickAndMortyClient

class EpisodesRepositoryImpl(
    private val theRickAndMortyClient: TheRickAndMortyClient
):EpisodesRepository {

    override suspend fun getEpisodesList(): ApiResult<EpisodesList> {
        return apiCall {
            theRickAndMortyClient.getEpisodesList()
        }
    }
}