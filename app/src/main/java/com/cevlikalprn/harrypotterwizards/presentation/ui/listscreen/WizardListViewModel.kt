package com.cevlikalprn.harrypotterwizards.presentation.ui.listscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.domain.usecase.FetchWizardsFromDatabaseUseCase
import com.cevlikalprn.harrypotterwizards.domain.usecase.FetchWizardsFromInternetUseCase
import com.cevlikalprn.harrypotterwizards.domain.usecase.InsertWizardsToDatabaseUseCase
import com.cevlikalprn.harrypotterwizards.domain.usecase.UpdateWizardStatusUseCase
import com.cevlikalprn.harrypotterwizards.domain.model.Wizard
import com.cevlikalprn.harrypotterwizards.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WizardListViewModel @Inject constructor(
    private val fetchWizardsFromInternetUseCase: FetchWizardsFromInternetUseCase,
    fetchWizardsFromDatabaseUseCase: FetchWizardsFromDatabaseUseCase,
    private val insertWizardsToDatabaseUseCase: InsertWizardsToDatabaseUseCase,
    private val updateWizardStatusUseCase: UpdateWizardStatusUseCase
) : ViewModel() {

    private var _wizardsFromInternet: MutableLiveData<NetworkResult<List<Wizard>>> =
        MutableLiveData()
    val wizardsFromInternet: LiveData<NetworkResult<List<Wizard>>>
        get() = _wizardsFromInternet

    val wizardsFromDatabase: LiveData<List<WizardEntity>> =
        fetchWizardsFromDatabaseUseCase()

    init {
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        _wizardsFromInternet.value = NetworkResult.Loading()
        viewModelScope.launch {
            try {
                val dataFromInternet = fetchWizardsFromInternetUseCase()
                if (!dataFromInternet.isNullOrEmpty()) {
                    _wizardsFromInternet.value = NetworkResult.Success(dataFromInternet)
                    insertWizardsToDatabaseUseCase((_wizardsFromInternet.value as NetworkResult.Success<List<Wizard>>).data!!)
                }
            } catch (e: Exception) {
                _wizardsFromInternet.value = NetworkResult.Error(null, e.message)
            }
        }
    }

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            updateWizardStatusUseCase(wizard)
        }
    }
}