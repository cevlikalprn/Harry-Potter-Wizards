package com.cevlikalprn.harrypotterwizards.favorite

import androidx.lifecycle.ViewModel
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository

class FavoriteWizardsViewModel(repository: WizardRepository) : ViewModel() {

    val favoriteWizards = repository.favoriteWizards

}