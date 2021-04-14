package com.therickandmorty.base



import com.therickandmorty.data.remote.TheRickAndMortyClient
import com.therickandmorty.data.repository.CharactersRepository
import com.therickandmorty.data.repository.CharactersRepositoryImpl
import com.therickandmorty.data.repository.EpisodesRepository
import com.therickandmorty.data.repository.EpisodesRepositoryImpl
import com.therickandmorty.ui.characters.CharactersViewModelFactory
import com.therickandmorty.ui.episodes.EpisodesViewModelFactory

object InjectorObject {

    private val theRickAndMortyClient = TheRickAndMortyClient()

    private val charactersRepository: CharactersRepository = CharactersRepositoryImpl(theRickAndMortyClient)
    fun getCharacterViewModelFactory() = CharactersViewModelFactory(charactersRepository)

    private val episodesRepository: EpisodesRepository = EpisodesRepositoryImpl(theRickAndMortyClient)
    fun getEpisodeViewModelFactory() = EpisodesViewModelFactory(episodesRepository)

}