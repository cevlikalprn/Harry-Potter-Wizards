package com.cevlikalprn.harrypotterwizards.ui.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class WizardListViewModel @Inject constructor(private val repository: WizardRepository) : ViewModel() {

    private var _wizardsFromInternet: MutableLiveData<NetworkResult<List<Wizard>>> =
        MutableLiveData()
    val wizardsFromInternet: LiveData<NetworkResult<List<Wizard>>>
        get() = _wizardsFromInternet

    val wizardsFromDatabase: LiveData<List<WizardEntity>> = repository.allWizards

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        _wizardsFromInternet.value = NetworkResult.Loading()
        viewModelScope.launch {
            try {
                val dataFromInternet = repository.getWizardsFromInternet()
                if (!dataFromInternet.isNullOrEmpty()) {
                    _wizardsFromInternet.value = NetworkResult.Success(dataFromInternet)
                    repository.insertWizardsToDatabase((_wizardsFromInternet.value as NetworkResult.Success<List<Wizard>>).data!!)
                }
            } catch (e: Exception) {
                _wizardsFromInternet.value = NetworkResult.Error(null, e.message)
            }
        }
    }

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            repository.updateWizard(wizard)
        }
    }

}

/*
* when (_wizardsFromInternet.value) {
                    is NetworkResult.Success -> repository.insertWizardsToDatabase(
                        (_wizardsFromInternet.value as NetworkResult.Success<List<Wizard>>).data!!
                    )
                    is NetworkResult.Error -> println("error")
                    is NetworkResult.Loading -> println("loading")
                }
*
* */