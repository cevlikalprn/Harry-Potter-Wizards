package com.cevlikalprn.harrypotterwizards.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity

class WizardDetailsViewModel: ViewModel() {

    val wizard = MutableLiveData<WizardEntity>()

}