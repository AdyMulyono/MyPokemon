package com.example.mypokemon.helper


import com.example.mypokemon.models.PokemonDetailsResponse
import com.example.mypokemon.models.PokemonResponse
import com.example.mypokemon.models.RegionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIServices {
    @GET("pokemon")
    fun getAllPokemon() : Call<PokemonResponse>

    @GET("pokedex")
    fun getAllRegion() : Call<RegionResponse>

    @GET("pokemon/{id}")
    fun getDetailPokemon(@Path("id") id : Int) : Call<PokemonDetailsResponse>
}