package com.example.pokedexinfo.model

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<TypeSlot>
)

data class TypeSlot(
    val type: PokemonType
)

data class PokemonType(
    val name: String
)




