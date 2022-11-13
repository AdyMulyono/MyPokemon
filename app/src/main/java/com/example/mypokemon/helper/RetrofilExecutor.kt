package com.example.mypokemon.helper

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofilExecutor {
    fun doRetroExecutor() : APIServices{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().build()
        val gson = GsonBuilder()
            .setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Const.baseURL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()

        return retrofit.create(APIServices::class.java)
    }
}