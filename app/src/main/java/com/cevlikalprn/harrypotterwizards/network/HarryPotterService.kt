package com.cevlikalprn.harrypotterwizards.network

import com.cevlikalprn.harrypotterwizards.models.Wizard
import com.cevlikalprn.harrypotterwizards.models.WizardItem
import com.cevlikalprn.harrypotterwizards.util.Constants.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HarryPotterService {

    @GET("api/characters")
    fun getWizards(): Response<Wizard>

}


object HarryPotterApi{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: HarryPotterService = retrofit.create(HarryPotterService::class.java)
}