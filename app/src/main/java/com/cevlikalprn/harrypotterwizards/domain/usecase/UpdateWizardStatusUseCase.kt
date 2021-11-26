package com.cevlikalprn.harrypotterwizards.domain.usecase

import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import javax.inject.Inject

class UpdateWizardStatusUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(wizard: WizardEntity) {
        repository.updateWizard(wizard)
    }
}