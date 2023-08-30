package com.example.pokedexinfo.model

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<PokemonType>
){
    val formattedNumber ="#${ id.toString().padStart(3, '0')}"

//    val imgUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${id}.png"
    val imgUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
//    val imgUrl: String = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}


