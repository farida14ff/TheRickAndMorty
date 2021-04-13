package com.therickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.therickandmorty.base.ApiResult
import com.therickandmorty.data.model.Character
import com.therickandmorty.data.repository.CharactersRepository

class CharactersViewModel(
    private val charactersRepository: CharactersRepository
):ViewModel() {

    val character = liveData<ApiResult<Character>> {
        emit(ApiResult.Loading)
//        val result = charactersRepository.getCharactersList()
//        emit(result)
    }
}