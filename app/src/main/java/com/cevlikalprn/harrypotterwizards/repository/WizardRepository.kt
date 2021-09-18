package com.cevlikalprn.harrypotterwizards.repository

import com.cevlikalprn.harrypotterwizards.models.Wizard
import com.cevlikalprn.harrypotterwizards.network.HarryPotterApi
import retrofit2.Response

class WizardRepository(private val api: HarryPotterApi ) {


    suspend fun getWizards(): Response<Wizard> = api.service.getWizards()


}