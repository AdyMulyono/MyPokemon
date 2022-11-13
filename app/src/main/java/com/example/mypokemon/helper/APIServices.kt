package com.example.mypokemon.helper


import com.example.mypokemon.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("pokemon")
    fun getAllPokemon() : Call<PokemonResponse>
}