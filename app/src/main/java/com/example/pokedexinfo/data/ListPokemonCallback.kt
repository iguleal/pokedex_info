package com.example.pokedexinfo.data

import com.example.pokedexinfo.model.Pokemon


interface ListPokemonCallback {
    fun onSuccess(pokemon: Pokemon)
    fun onFailure(message:String)
}