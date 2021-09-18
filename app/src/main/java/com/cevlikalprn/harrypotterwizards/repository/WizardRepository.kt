package com.cevlikalprn.harrypotterwizards.repository

import com.cevlikalprn.harrypotterwizards.models.Wizard
import com.cevlikalprn.harrypotterwizards.network.HarryPotterApi
import com.cevlikalprn.harrypotterwizards.network.HarryPotterService
import retrofit2.Response

class WizardRepository() {

    suspend fun getWizards(): Response<Wizard> = HarryPotterApi.service.getWizards()


}