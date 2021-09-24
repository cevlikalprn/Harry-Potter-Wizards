package com.cevlikalprn.harrypotterwizards.data.repository

import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.models.Wizard
import retrofit2.Response

class WizardRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun getWizards(): Response<Wizard>{
        return remoteDataSource.getWizards()
    }

}