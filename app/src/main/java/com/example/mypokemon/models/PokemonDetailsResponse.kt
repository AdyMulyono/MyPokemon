package com.example.mypokemon.models

data class PokemonDetailsResponse(
    val abilities : ArrayList<AbilitiesModel>,
    val height : Long,
    val weight : Long,
    val sprites : SpritesModel
){
    data class AbilitiesModel(
        val ability : AbilityModel,
        val is_hidden : Boolean,
        val slot: Int
    ){
        data class AbilityModel(
            val name : String,
            val url : String
        )
    }

    data class SpritesModel(
        val front_default : String
    )
}