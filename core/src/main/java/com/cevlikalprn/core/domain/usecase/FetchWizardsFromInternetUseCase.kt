package com.cevlikalprn.core.domain.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.core.data.database.WizardEntity
import com.cevlikalprn.core.data.repository.WizardRepository
import com.cevlikalprn.core.domain.model.Wizard
import javax.inject.Inject

class FetchWizardsFromInternetUseCase @Inject constructor(private val repository: WizardRepository) {

    suspend operator fun invoke(): List<Wizard> {
        return repository.getWizardsFromInternet()
    }
}