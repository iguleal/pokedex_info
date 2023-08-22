package com.example.pokedexinfo.data

import com.example.pokedexinfo.model.Pokemon
import retrofit2.await

class PokemonRemoteDataSource {

    private val service: PokeDexAPI = HTTPClient.retrofit().create(PokeDexAPI::class.java)

    suspend fun findAllPokemon(callback: ListPokemonCallback) {

        for (number in 1..151) {
            val response = service.findAllPokemons(number).await()

            val pokemon = Pokemon(
                id = number,
                name = response.name,
                types = response.types.map { it.type }

            )
            callback.onSuccess(pokemon)
        }


    }
}