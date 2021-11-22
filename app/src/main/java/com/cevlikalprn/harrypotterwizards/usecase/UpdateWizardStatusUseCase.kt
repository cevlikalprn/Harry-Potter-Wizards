package com.cevlikalprn.harrypotterwizards.usecase

import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import javax.inject.Inject

class UpdateWizardStatusUseCase @Inject constructor(private val repository: WizardRepository) {

    //update the status of the wizard
    suspend fun updateWizard(wizard: WizardEntity) {
        repository.updateWizard(wizard)
    }
}