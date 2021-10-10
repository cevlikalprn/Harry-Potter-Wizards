package com.cevlikalprn.harrypotterwizards.adapter

import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity

interface AdapterClickListener {

    fun updateWizard(wizard: WizardEntity)

    fun onItemClicked(wizard: WizardEntity)
}