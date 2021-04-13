package com.therickandmorty.base



import com.therickandmorty.data.remote.TheRickAndMortyClient
import com.therickandmorty.data.repository.CharactersRepository
import com.therickandmorty.data.repository.CharactersRepositoryImpl
import com.therickandmorty.ui.characters.CharactersViewModelFactory

object InjectorObject {

    val theRickAndMortyClient = TheRickAndMortyClient()

    val whetherRepository: CharactersRepository = CharactersRepositoryImpl(theRickAndMortyClient)

    fun getMainViewModelFactory() = CharactersViewModelFactory(whetherRepository)
}