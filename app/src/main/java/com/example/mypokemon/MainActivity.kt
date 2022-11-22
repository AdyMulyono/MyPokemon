package com.example.mypokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemon.adapter.ListPokemonAdapter
import com.example.mypokemon.databinding.ActivityMainBinding
import com.example.mypokemon.helper.RetrofilExecutor
import com.example.mypokemon.models.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    private val binding by lazy{
        ActivityMainBinding.inflate((layoutInflater))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rcView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        populatePokemon()
    }

    private fun populatePokemon() {
        RetrofilExecutor.doRetroExecutor().getAllPokemon().enqueue(
            object : Callback<PokemonResponse>{
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if (response.isSuccessful){
                        val data = response.body()
                        val adapter =ListPokemonAdapter(data!!.results)
                        binding.rcView.adapter = adapter
                    }else
                    {
                        Toast.makeText(this@MainActivity, response.message(),Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message,Toast.LENGTH_SHORT).show()
                }

            }
        )
    }
    rvMain.apply {
        layoutManager = GridLayoutManager(this@MainActivity, 3)
        adapter = ListPokemonAdapter
    }

}