package com.example.mypokemon.helper


import com.example.mypokemon.models.PokemonResponse
import com.example.mypokemon.models.RegionResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIServices {
    @GET("pokemon")
    fun getAllPokemon() : Call<PokemonResponse>

    @GET("region")
    fun getAllRegion() : Call<RegionResponse>
}