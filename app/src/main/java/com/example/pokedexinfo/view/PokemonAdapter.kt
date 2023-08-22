package com.example.pokedexinfo.view

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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

        viewHolder.itemView.findViewById<Button>(R.id.btn_type1).text = pokemon.types[0].name

        val type2 = viewHolder.itemView.findViewById<Button>(R.id.btn_type2)

        if (pokemon.types.size == 2) {
            type2.text = pokemon.types[1].name
            type2.visibility = View.VISIBLE
        } else {
            type2.visibility = View.GONE
        }

    }

    override fun createViewHolder(itemView: View) = PokemonViewHolder(itemView)

    override fun getLayout() = R.layout.item_pokemon
}