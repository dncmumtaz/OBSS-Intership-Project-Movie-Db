package co.obss.tr.obsstest.network

import co.obss.tr.obsstest.model.ApiResponse
import co.obss.tr.obsstest.model.Character
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyService {

    @GET("character/")
    fun getCharacters(): Call<ApiResponse>

}