package com.cevlikalprn.core.data

import com.cevlikalprn.core.data.network.HarryPotterService
import com.cevlikalprn.core.domain.model.Wizard
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val retrofit: HarryPotterService) {

    suspend fun getWizards(): List<Wizard>{
        return retrofit.getWizards()
    }

}