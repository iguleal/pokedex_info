package com.example.pokedexinfo.data

import com.example.pokedexinfo.model.PokemonApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeDexAPI {

    @GET("{id}")
    fun findAllPokemons(@Path("id") idPokemon: Int): Call<PokemonApiResult>

}