package com.example.mypokemon.models

data class PokemonResponse(
    val count : Long,
    val next : String,
    val previous : String ?= null,
    val results : ArrayList<PokemonData>){
        data class PokemonData(val name : String, val url :String)
}
