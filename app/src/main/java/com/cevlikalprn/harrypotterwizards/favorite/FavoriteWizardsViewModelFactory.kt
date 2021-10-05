package com.cevlikalprn.harrypotterwizards.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository

class FavoriteWizardsViewModelFactory(private val repository: WizardRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteWizardsViewModel::class.java)) {
            return FavoriteWizardsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}