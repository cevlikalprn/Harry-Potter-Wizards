package com.cevlikalprn.harrypotterwizards.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import kotlinx.coroutines.launch

class FavoriteWizardsViewModel(private val repository: WizardRepository) : ViewModel() {

    val favoriteWizards = repository.favoriteWizards

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }
}