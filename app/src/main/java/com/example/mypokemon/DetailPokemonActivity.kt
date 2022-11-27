package com.example.mypokemon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mypokemon.adapter.AbilitiesAdapter
import com.example.mypokemon.databinding.ActivityDetailPokemonBinding
import com.example.mypokemon.helper.RetrofilExecutor
import com.example.mypokemon.models.PokemonDetailRespone
import retrofit2.Callback
import retrofit2.Response

class DetailPokemonActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailPokemonBinding.inflate(layoutInflater)
    }
    private var pokemonName : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setView()
    }

    private fun setView() {
        val id = intent.getIntExtra("id",0)
        pokemonName = intent.getStringExtra("pokemonName") ?: ""
        binding.rcView.layoutManager = LinearLayoutManager(this)
        populateDetailPokemon(id)
    }

    private fun populateDetailPokemon(id: Int) {
        RetrofilExecutor.doRetroExecutor().getDetailPokemon(id).enqueue(
            object : Callback<PokemonDetailRespone> {
                override fun onResponse(
                    call: retrofit2.Call<PokemonDetailRespone>,
                    response: Response<PokemonDetailRespone>
                ) {
                    if (response.isSuccessful){
                    val data = response.body()
                    if (data != null){
                        binding.namapokemon.text = pokemonName
                        binding.tvHeight.text = "Height : ${data.height} Cm"
                        binding.tvWight.text = "Weight : ${data.weight} Kg"
                        binding.rcView.adapter = AbilitiesAdapter(data.abilities)
                        Glide.with(binding.imageView2)
                            .load(data.sprites.front_default)
                            .error(android.R.drawable.ic_menu_gallery)
                            .into(binding.imageView2)
                        }
                    }
                        else{
                            Toast.makeText(this@DetailPokemonActivity,"Error load", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: retrofit2.Call<PokemonDetailRespone>, t: Throwable) {
                    Toast.makeText(this@DetailPokemonActivity,"Error load", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

}