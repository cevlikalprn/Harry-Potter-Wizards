package com.cevlikalprn.harrypotterwizards.domain.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.domain.model.Wizard
import javax.inject.Inject

class FetchWizardsFromInternetUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(): List<Wizard> {
        return repository.getWizardsFromInternet()
    }
}