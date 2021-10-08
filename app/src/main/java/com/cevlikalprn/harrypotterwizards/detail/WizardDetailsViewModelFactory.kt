package com.cevlikalprn.harrypotterwizards.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository

class WizardDetailsViewModelFactory(private val repository: WizardRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WizardDetailsViewModel::class.java)) {
            return WizardDetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}