package com.cevlikalprn.harrypotterwizards.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.model.Wizard
import javax.inject.Inject

class FetchWizardsUseCase @Inject constructor(private val repository: WizardRepository) {

    //fetch all wizards from database
    val fetchWizardsFromDatabase = repository.allWizards

    //fetch favorite wizards from database
    val fetchFavoriteWizards = repository.favoriteWizards

    //fetch all wizards from internet
    suspend fun fetchWizardsFromInternet(): List<Wizard> {
        return repository.getWizardsFromInternet()
    }
}