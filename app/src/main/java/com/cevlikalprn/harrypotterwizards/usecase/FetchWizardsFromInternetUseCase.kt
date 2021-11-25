package com.cevlikalprn.harrypotterwizards.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.model.Wizard
import javax.inject.Inject

class FetchWizardsFromInternetUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(): List<Wizard> {
        return repository.getWizardsFromInternet()
    }
}