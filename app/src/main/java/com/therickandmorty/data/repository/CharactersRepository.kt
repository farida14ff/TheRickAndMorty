package com.therickandmorty.data.repository

import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.Character

interface CharactersRepository {

    suspend fun getCharactersList(): ApiResult<Character>

}