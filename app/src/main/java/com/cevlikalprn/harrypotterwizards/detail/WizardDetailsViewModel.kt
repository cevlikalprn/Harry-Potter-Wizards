package com.cevlikalprn.harrypotterwizards.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cevlikalprn.harrypotterwizards.model.Wizard

class WizardDetailsViewModel: ViewModel() {

    val wizard = MutableLiveData<Wizard>()


}