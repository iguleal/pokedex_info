package com.example.pokedexinfo.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.pokedexinfo.R
import com.example.pokedexinfo.model.Pokemon
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class PokemonAdapter(private val pokemon: Pokemon) : Item<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : GroupieViewHolder(view)

    override fun bind(viewHolder: PokemonViewHolder, position: Int) {
        val imgPoke = viewHolder.itemView.findViewById<ImageView>(R.id.img_poke)
        Picasso.get().load(pokemon.imgUrl).into(imgPoke)

        viewHolder.itemView.findViewById<TextView>(R.id.txt_poke_id).text = pokemon.formattedNumber
        viewHolder.itemView.findViewById<TextView>(R.id.txt_poke_name).text = pokemon.name.replaceFirstChar { it.uppercase() }
        val type1 = viewHolder.itemView.findViewById<Button>(R.id.btn_type1)
        val type2 = viewHolder.itemView.findViewById<Button>(R.id.btn_type2)

        type1.text = pokemon.types[0].name
        type1.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context, getColorByType(pokemon.types[0].name)))

        if (pokemon.types.size == 2) {
            type2.text = pokemon.types[1].name
            type2.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.context, getColorByType(pokemon.types[1].name)))
            type2.visibility = View.VISIBLE
        } else {
            type2.visibility = View.GONE
        }

    }

    override fun createViewHolder(itemView: View) = PokemonViewHolder(itemView)

    override fun getLayout() = R.layout.item_pokemon

    private fun getColorByType(type: String): Int {
        return when (type.uppercase()) {
            "NORMAL" -> R.color.gray_200
            "FIGHTING" -> R.color.red_400
            "FLYING" -> R.color.blue_200
            "POISON" -> R.color.lilac_200
            "GROUND" -> R.color.orange_700
            "ROCK" -> R.color.yellow_100
            "BUG" -> R.color.green_500
            "GHOST" -> R.color.purple_400
            "STEEL" -> R.color.teal_200
            "FIRE" -> R.color.orange_500
            "WATER" -> R.color.blue_300
            "GRASS" -> R.color.green_700
            "ELECTRIC" -> R.color.yellow_500
            "PSYCHIC" -> R.color.red_300
            "ICE" -> R.color.teal_200
            "DRAGON" -> R.color.blue_500
            "DARK" -> R.color.gray_500
            "FAIRY" -> R.color.pink_500
            "SHADOW" -> R.color.gray_400
            else -> R.color.gray_400 //UNKNOWN
        }
    }

    private fun getIconType(type: String): Int{
        return when (type.uppercase()) {
            "NORMAL" -> R.color.gray_200
            "FIGHTING" -> R.color.red_400
            "FLYING" -> R.color.blue_200
            "POISON" -> R.color.lilac_200
            "GROUND" -> R.color.orange_700
            "ROCK" -> R.color.yellow_100
            "BUG" -> R.color.green_500
            "GHOST" -> R.color.purple_400
            "STEEL" -> R.color.teal_200
            "FIRE" -> R.color.orange_500
            "WATER" -> R.color.blue_300
            "GRASS" -> R.color.green_700
            "ELECTRIC" -> R.color.yellow_500
            "PSYCHIC" -> R.color.red_300
            "ICE" -> R.color.teal_200
            "DRAGON" -> R.color.blue_500
            "DARK" -> R.color.gray_500
            "FAIRY" -> R.color.pink_500
            "SHADOW" -> R.color.gray_400
            else -> R.color.gray_400 //UNKNOWN
        }
    }
}