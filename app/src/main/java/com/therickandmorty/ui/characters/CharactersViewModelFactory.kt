package com.therickandmorty.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.therickandmorty.data.repository.CharactersRepository

class CharactersViewModelFactory(
    private val charactersRepository: CharactersRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CharactersViewModel::class.java) ->
                CharactersViewModel(charactersRepository) as T
            else -> throw IllegalArgumentException("Not found")
        }
    }
}