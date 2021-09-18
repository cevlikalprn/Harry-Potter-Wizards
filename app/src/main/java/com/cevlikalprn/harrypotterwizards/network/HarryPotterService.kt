package com.cevlikalprn.harrypotterwizards.network

import com.cevlikalprn.harrypotterwizards.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface HarryPotterService {



}


object HarryPotterApi{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: HarryPotterService = retrofit.create(HarryPotterService::class.java)
}