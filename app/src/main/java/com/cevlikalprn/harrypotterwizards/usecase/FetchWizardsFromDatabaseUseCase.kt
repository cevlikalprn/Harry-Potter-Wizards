package com.cevlikalprn.harrypotterwizards.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import javax.inject.Inject

class FetchWizardsFromDatabaseUseCase @Inject constructor(private val repository: WizardRepository) {

    operator fun invoke(): LiveData<List<WizardEntity>> = repository.allWizards
}