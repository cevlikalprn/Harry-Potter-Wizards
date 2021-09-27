package com.cevlikalprn.harrypotterwizards.data.repository

import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.model.Wizard
import retrofit2.Response

class WizardRepository(private val remoteDataSource: RemoteDataSource) {

    //Repository'nin kullanımı pek doğru değil

    suspend fun getWizards(): Response<List<Wizard>>{
        return remoteDataSource.getWizards()
    }

}