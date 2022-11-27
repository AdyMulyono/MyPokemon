package com.example.mypokemon.adapter

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypokemon.databinding.ActivityMainBinding.inflate
import com.example.mypokemon.databinding.ActivitySplashBinding.inflate
import com.example.mypokemon.databinding.ItemAbilitiesBinding
import com.example.mypokemon.models.PokemonDetailRespone

class AbilitiesAdapter (private val listAbilities : ArrayList<PokemonDetailRespone.AbilitiesModel>)
    :RecyclerView.Adapter<AbilitiesAdapter.Abilitiesholder>(){

    class Abilitiesholder (val binding : ItemAbilitiesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind (datalist : PokemonDetailRespone.AbilitiesModel){
            binding.tvAbilities.text = datalist.ability.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= Abilitiesholder (
        ItemAbilitiesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: Abilitiesholder, position: Int) {
        holder.bind(listAbilities[position])
    }

    override fun getItemCount()= listAbilities.size

}