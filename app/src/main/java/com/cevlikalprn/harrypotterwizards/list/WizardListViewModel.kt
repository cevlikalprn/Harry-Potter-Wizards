package com.cevlikalprn.harrypotterwizards.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.util.NetworkResult
import kotlinx.coroutines.launch
import java.lang.Exception

class WizardListViewModel(private val repository: WizardRepository) : ViewModel() {

    private val _wizards: MutableLiveData<NetworkResult<List<Wizard>>> = MutableLiveData()
    val wizards: LiveData<NetworkResult<List<Wizard>>>
        get() = _wizards

    init {
        loadWizards()
    }

    private fun loadWizards() {
        viewModelScope.launch {
            _wizards.value = NetworkResult.Loading()
            getWizards()
        }
    }

    private suspend fun getWizards() {
        try {
            val response = repository.remote.getWizards()
            if (!response.isNullOrEmpty()) {
                _wizards.value = NetworkResult.Success(response)
            }
        } catch (e: Exception) {
            _wizards.value = NetworkResult.Error(errorMessage = e.message)
        }
    }
}