package com.cevlikalprn.core.domain.usecase

import com.cevlikalprn.core.data.database.WizardEntity
import com.cevlikalprn.core.data.repository.WizardRepository
import javax.inject.Inject

class UpdateWizardStatusUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(wizard: WizardEntity) {
        repository.updateWizard(wizard)
    }
}