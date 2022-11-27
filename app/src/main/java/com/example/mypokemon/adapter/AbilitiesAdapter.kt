package com.example.mypokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.databinding.ItemAbilitiesBinding
import com.example.mypokemon.models.PokemonDetailsResponse

class AbilitiesAdapter(private val listAbilities : ArrayList<PokemonDetailsResponse.AbilitiesModel>)
    :RecyclerView.Adapter<AbilitiesAdapter.AbilitiesVHolder>(){

    class AbilitiesVHolder(val binding : ItemAbilitiesBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : PokemonDetailsResponse.AbilitiesModel){
            binding.tvAbilityName.text = item.ability.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AbilitiesVHolder(ItemAbilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: AbilitiesVHolder, position: Int) { holder.bind(listAbilities[position]) }
    override fun getItemCount() = listAbilities.size
}