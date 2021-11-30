package com.cevlikalprn.harrypotterwizards.presentation.ui.favoritescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevlikalprn.core.data.database.WizardEntity
import com.cevlikalprn.core.domain.usecase.FetchFavoriteWizardsUseCase
import com.cevlikalprn.core.domain.usecase.FetchWizardsFromInternetUseCase
import com.cevlikalprn.core.domain.usecase.UpdateWizardStatusUseCase
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