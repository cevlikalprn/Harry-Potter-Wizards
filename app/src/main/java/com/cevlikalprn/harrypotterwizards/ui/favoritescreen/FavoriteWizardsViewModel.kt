package com.cevlikalprn.harrypotterwizards.ui.favoritescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.usecase.FetchFavoriteWizardsUseCase
import com.cevlikalprn.harrypotterwizards.usecase.FetchWizardsFromInternetUseCase
import com.cevlikalprn.harrypotterwizards.usecase.UpdateWizardStatusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteWizardsViewModel @Inject constructor(
    fetchFavoriteWizardsUseCase: FetchFavoriteWizardsUseCase,
    private val updateWizardStatusUseCase: UpdateWizardStatusUseCase
) : ViewModel() {

    val favoriteWizards = fetchFavoriteWizardsUseCase()

    fun updateWizard(wizard: WizardEntity) {
        viewModelScope.launch {
            updateWizardStatusUseCase(wizard)
        }
    }
}