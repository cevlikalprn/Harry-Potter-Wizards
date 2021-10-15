package com.cevlikalprn.harrypotterwizards.ui.favoritescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteWizardsViewModel @Inject constructor(private val repository: WizardRepository) : ViewModel() {

    val favoriteWizards = repository.favoriteWizards

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }
}