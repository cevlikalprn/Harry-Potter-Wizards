package com.cevlikalprn.harrypotterwizards.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cevlikalprn.harrypotterwizards.models.WizardItem

class WizardDetailsViewModel: ViewModel() {

    val wizard = MutableLiveData<WizardItem>()


}