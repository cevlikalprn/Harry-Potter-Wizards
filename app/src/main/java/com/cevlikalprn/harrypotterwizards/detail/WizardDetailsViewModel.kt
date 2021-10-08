package com.cevlikalprn.harrypotterwizards.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import kotlinx.coroutines.launch

class WizardDetailsViewModel(private val repository: WizardRepository) : ViewModel() {

    val wizard = MutableLiveData<WizardEntity>()

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }

}