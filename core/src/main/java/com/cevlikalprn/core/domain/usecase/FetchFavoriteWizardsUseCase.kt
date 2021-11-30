package com.cevlikalprn.core.domain.usecase

import androidx.lifecycle.LiveData
import com.cevlikalprn.core.data.database.WizardEntity
import com.cevlikalprn.core.data.repository.WizardRepository
import javax.inject.Inject

class FetchFavoriteWizardsUseCase @Inject constructor(private val repository: WizardRepository) {

    operator fun invoke(): LiveData<List<WizardEntity>> = repository.favoriteWizards
}