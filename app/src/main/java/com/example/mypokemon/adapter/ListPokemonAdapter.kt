package com.example.mypokemon.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.DetailPokemonActivity
import com.example.mypokemon.databinding.ItemPokemonBinding
import com.example.mypokemon.models.PokemonResponse
import com.example.mypokemon.models.RegionResponse

class ListPokemonAdapter(private val listPokemon: ArrayList<PokemonResponse.PokemonData>)
    :RecyclerView.Adapter<ListPokemonAdapter.ListPokemonholder>() {

    class ListPokemonholder (val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (datalist: PokemonResponse.PokemonData, position: Int){
            binding.tvTitle.text = datalist.name
            binding.imageView.setOnClickListener { tombol ->
                tombol.context.startActivity(
                    Intent(tombol.context, DetailPokemonActivity::class.java)
                        .putExtra("pokemonName", datalist.name)
                        .putExtra("id", position+1)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ListPokemonholder (
        ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ListPokemonholder, position: Int) {
        holder.bind((listPokemon[position]), position)
    }

    override fun getItemCount()= listPokemon.size


}