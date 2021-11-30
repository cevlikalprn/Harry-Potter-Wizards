package com.cevlikalprn.core.domain.usecase

import com.cevlikalprn.core.data.repository.WizardRepository
import com.cevlikalprn.core.domain.model.Wizard
import javax.inject.Inject

class InsertWizardsToDatabaseUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(wizards: List<Wizard>) {
        repository.insertWizardsToDatabase(wizards)
    }
}