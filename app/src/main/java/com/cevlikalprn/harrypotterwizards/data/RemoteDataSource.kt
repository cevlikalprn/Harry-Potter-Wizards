package com.cevlikalprn.harrypotterwizards.data

import com.cevlikalprn.harrypotterwizards.models.Wizard
import com.cevlikalprn.harrypotterwizards.data.network.HarryPotterService
import retrofit2.Response

class RemoteDataSource(private val retrofit: HarryPotterService) {

    suspend fun getWizards(): Response<Wizard>{
        return retrofit.getWizards()
    }

}