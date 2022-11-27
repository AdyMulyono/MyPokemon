package com.example.mypokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypokemon.adapter.ListPokemonAdapter
import com.example.mypokemon.adapter.ListPokemonAdapter1
import com.example.mypokemon.databinding.ActivityMainBinding
import com.example.mypokemon.helper.RetrofilExecutor
import com.example.mypokemon.models.PokemonResponse
import com.example.mypokemon.models.RegionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity() : AppCompatActivity(), Parcelable {
    private val binding by lazy{
        ActivityMainBinding.inflate((layoutInflater))
    }

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rcView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
//        binding.rcView.layoutManager = GridLayoutManager(this, 4 )
        populatePokemon()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding.rcView.layoutManager = GridLayoutManager(this, 4 )
        populateregion()
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
                        val adapter = ListPokemonAdapter(data!!.results)
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

//    private fun ListPokemonAdapter1(listPokemon: ArrayList<PokemonResponse.PokemonData>): ListPokemonAdapter1 {
//        //test
//    }

    private fun populateregion(){
    RetrofilExecutor.doRetroExecutor().getAllRegion().enqueue(
        object : Callback<RegionResponse> {

            override fun onResponse(
                call: Call<RegionResponse>,
                response: Response<RegionResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val adapter = ListPokemonAdapter1(data!!.results)
                    binding.rcMain.adapter = adapter
                }

            }
            override fun onFailure(call: Call<RegionResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        }



    )

}

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}


