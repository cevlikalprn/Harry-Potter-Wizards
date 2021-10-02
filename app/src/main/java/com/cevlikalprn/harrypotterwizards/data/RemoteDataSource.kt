package com.cevlikalprn.harrypotterwizards.data

import com.cevlikalprn.harrypotterwizards.data.network.HarryPotterService
import com.cevlikalprn.harrypotterwizards.model.Wizard
import retrofit2.Response

class RemoteDataSource(private val retrofit: HarryPotterService) {

    suspend fun getWizards(): List<Wizard>{
        return retrofit.getWizards()
    }

}