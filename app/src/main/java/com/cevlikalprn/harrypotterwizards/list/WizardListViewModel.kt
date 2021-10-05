package com.cevlikalprn.harrypotterwizards.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class WizardListViewModel(private val repository: WizardRepository) : ViewModel() {

    val wizards = repository.allWizards

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                repository.insertWizardsToDatabase()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }

}