package com.cevlikalprn.harrypotterwizards.data.network

import com.cevlikalprn.harrypotterwizards.model.Wizard
import retrofit2.Response
import retrofit2.http.GET

interface HarryPotterService {

    @GET("api/characters")
    suspend fun getWizards(): List<Wizard>

}
