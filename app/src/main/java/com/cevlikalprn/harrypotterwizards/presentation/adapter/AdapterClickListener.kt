package com.cevlikalprn.harrypotterwizards.presentation.adapter

import com.cevlikalprn.core.data.database.WizardEntity

interface AdapterClickListener {

    fun updateWizard(wizard: WizardEntity)

    fun onItemClicked(wizard: WizardEntity)
}