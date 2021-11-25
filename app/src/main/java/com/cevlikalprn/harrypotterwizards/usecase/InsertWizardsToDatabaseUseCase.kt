package com.cevlikalprn.harrypotterwizards.usecase

import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.model.Wizard
import javax.inject.Inject

class InsertWizardsToDatabaseUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(wizards: List<Wizard>) {
        repository.insertWizardsToDatabase(wizards)
    }
}