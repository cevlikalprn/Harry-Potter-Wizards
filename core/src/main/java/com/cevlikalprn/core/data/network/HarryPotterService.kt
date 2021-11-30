package com.cevlikalprn.core.data.network

import com.cevlikalprn.core.domain.model.Wizard
import retrofit2.http.GET

interface HarryPotterService {

    @GET("api/characters")
    suspend fun getWizards(): List<Wizard>

}
