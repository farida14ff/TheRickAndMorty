package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.CharactersList

interface CharactersRepository {

    suspend fun getCharactersList(): ApiResult<CharactersList>

}