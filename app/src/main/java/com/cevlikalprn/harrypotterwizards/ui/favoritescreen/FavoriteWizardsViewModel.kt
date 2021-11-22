package com.cevlikalprn.harrypotterwizards.ui.favoritescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.usecase.FetchWizardsUseCase
import com.cevlikalprn.harrypotterwizards.usecase.UpdateWizardStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteWizardsViewModel @Inject constructor(
    fetchWizardsUseCase: FetchWizardsUseCase,
    private val updateWizardStatusUseCase: UpdateWizardStatusUseCase
) : ViewModel() {

    val favoriteWizards = fetchWizardsUseCase.fetchFavoriteWizards

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            updateWizardStatusUseCase.updateWizard(wizard)
        }
    }
}