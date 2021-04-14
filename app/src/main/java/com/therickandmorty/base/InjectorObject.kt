package com.therickandmorty.base



import com.therickandmorty.data.remote.TheRickAndMortyClient
import com.therickandmorty.data.repository.*
import com.therickandmorty.ui.characters.CharactersViewModelFactory
import com.therickandmorty.ui.episodes.EpisodesViewModelFactory
import com.therickandmorty.ui.locations.LocationViewModelFactory

object InjectorObject {

    private val theRickAndMortyClient = TheRickAndMortyClient()

    private val charactersRepository: CharactersRepository = CharactersRepositoryImpl(theRickAndMortyClient)
    fun getCharacterViewModelFactory() = CharactersViewModelFactory(charactersRepository)

    private val episodesRepository: EpisodesRepository = EpisodesRepositoryImpl(theRickAndMortyClient)
    fun getEpisodeViewModelFactory() = EpisodesViewModelFactory(episodesRepository)

    private val locationRepository: LocationRepository = LocationRepositoryImpl(theRickAndMortyClient)
    fun getLocationViewHolderFactory() = LocationViewModelFactory(locationRepository)

}