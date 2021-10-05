package com.cevlikalprn.harrypotterwizards.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class WizardListViewModel(private val repository: WizardRepository) : ViewModel() {

    val wizards = repository.allWizards

    init {
        refreshDataFromRepositorty()
    }

    private fun refreshDataFromRepositorty() {
        viewModelScope.launch {
            try {
                repository.insertWizardsToDatabase()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

/*
    private fun getWizards() {
        try {
            val response = repository.allWizards.value
            if (!response.isNullOrEmpty()) {
                println("This line is not working")
                _wizards.value = Result.Success(response)
            }
        } catch (e: Exception) {
            _wizards.value = Result.Error(errorMessage = e.message)
        }
    }

 */
}