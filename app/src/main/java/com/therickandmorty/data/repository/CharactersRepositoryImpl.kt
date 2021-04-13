package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.base.apiCall
import com.therickandmorty.data.model.Character
import com.therickandmorty.data.remote.TheRickAndMortyClient

class CharactersRepositoryImpl (
    private val theRickAndMortyClient: TheRickAndMortyClient
) : CharactersRepository {


    override suspend fun getCharactersList(): ApiResult<Character> {
        return apiCall { theRickAndMortyClient.getCharactersList() }
    }

}