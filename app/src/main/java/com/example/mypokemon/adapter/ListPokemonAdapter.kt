package com.example.mypokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.databinding.ItemPokemonBinding
import com.example.mypokemon.models.PokemonResponse

class ListPokemonAdapter(private val listPokemon:ArrayList<PokemonResponse.PokemonData>)
    :RecyclerView.Adapter<ListPokemonAdapter.ListPokemonholder>() {

    class ListPokemonholder (val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root){
        fun bind (datalist : PokemonResponse.PokemonData){
            binding.tvTitle.text = datalist.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ListPokemonholder (
        ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    override fun onBindViewHolder(holder: ListPokemonholder, position: Int) {
        holder.bind((listPokemon[position]))
    }

    override fun getItemCount()= listPokemon.size


}