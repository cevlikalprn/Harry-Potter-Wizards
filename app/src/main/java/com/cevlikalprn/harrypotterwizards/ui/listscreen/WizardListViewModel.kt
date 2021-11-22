package com.cevlikalprn.harrypotterwizards.ui.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.usecase.FetchWizardsUseCase
import com.cevlikalprn.harrypotterwizards.usecase.InsertWizardsToDatabaseUseCase
import com.cevlikalprn.harrypotterwizards.usecase.UpdateWizardStatusUseCase
import com.cevlikalprn.harrypotterwizards.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WizardListViewModel @Inject constructor(
    private val fetchWizardsUseCase: FetchWizardsUseCase,
    private val insertWizardsToDatabaseUseCase: InsertWizardsToDatabaseUseCase,
    private val updateWizardStatusUseCase: UpdateWizardStatusUseCase
) : ViewModel() {

    private var _wizardsFromInternet: MutableLiveData<NetworkResult<List<Wizard>>> =
        MutableLiveData()
    val wizardsFromInternet: LiveData<NetworkResult<List<Wizard>>>
        get() = _wizardsFromInternet

    val wizardsFromDatabase: LiveData<List<WizardEntity>> =
        fetchWizardsUseCase.fetchWizardsFromDatabase

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        _wizardsFromInternet.value = NetworkResult.Loading()
        viewModelScope.launch {
            try {
                val dataFromInternet = fetchWizardsUseCase.fetchWizardsFromInternet()
                if (!dataFromInternet.isNullOrEmpty()) {
                    _wizardsFromInternet.value = NetworkResult.Success(dataFromInternet)
                    insertWizardsToDatabaseUseCase.insertWizardsToDatabase((_wizardsFromInternet.value as NetworkResult.Success<List<Wizard>>).data!!)
                }
            } catch (e: Exception) {
                _wizardsFromInternet.value = NetworkResult.Error(null, e.message)
            }
        }
    }

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            updateWizardStatusUseCase.updateWizard(wizard)
        }
    }
}