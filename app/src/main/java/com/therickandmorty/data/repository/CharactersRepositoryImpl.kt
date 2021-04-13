package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.apiCall
import com.therickandmorty.data.model.CharactersList
import com.therickandmorty.data.remote.TheRickAndMortyClient

class CharactersRepositoryImpl (
    private val theRickAndMortyClient: TheRickAndMortyClient
) : CharactersRepository {


    override suspend fun getCharactersList(): ApiResult<CharactersList> {
        return apiCall { theRickAndMortyClient.getCharactersList() }
    }

}