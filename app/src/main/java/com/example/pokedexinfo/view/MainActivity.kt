package com.example.pokedexinfo.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexinfo.R
import com.example.pokedexinfo.databinding.ActivityMainBinding
import com.example.pokedexinfo.presentation.MainPresenter
import com.xwray.groupie.GroupieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = GroupieAdapter()
    private val presenter = MainPresenter(this)
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvHome.adapter = adapter

        if (adapter.itemCount == 0) {
            scope.launch {
                presenter.findAllPokemon()
            }
        }
    }

    fun showPokemon(pokemonAdapter: PokemonAdapter) {
        adapter.add(pokemonAdapter)
        adapter.notifyDataSetChanged()
    }

    fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun visibilityProgressBar(visibility: Boolean) {
        if (visibility) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}