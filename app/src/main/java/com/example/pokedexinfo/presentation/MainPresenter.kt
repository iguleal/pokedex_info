package com.example.pokedexinfo.presentation

import com.example.pokedexinfo.data.ListPokemonCallback
import com.example.pokedexinfo.data.PokemonRemoteDataSource
import com.example.pokedexinfo.model.Pokemon
import com.example.pokedexinfo.view.MainActivity
import com.example.pokedexinfo.view.PokemonAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainActivity,
    private val dataSource: PokemonRemoteDataSource = PokemonRemoteDataSource()
) : ListPokemonCallback {

    fun findAllPokemon() {
        val scope = CoroutineScope(Dispatchers.Main)
        view.visibilityProgressBar(true)
        scope.launch {
            dataSource.findAllPokemon(this@MainPresenter)
        }
    }

    override fun onSuccess(pokemon: Pokemon) {
        val pokemonAdapter = PokemonAdapter(pokemon)
        view.showPokemon(pokemonAdapter)
        view.visibilityProgressBar(false)
    }

    override fun onFailure(message: String) {
        view.showError(message)
        view.visibilityProgressBar(false)
    }
}