package com.cevlikalprn.harrypotterwizards.ui.detailscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WizardDetailsViewModel @Inject constructor(private val repository: WizardRepository) :
    ViewModel() {

    val wizard = MutableLiveData<WizardEntity>()

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }

}