package com.cevlikalprn.harrypotterwizards.data

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardDao
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity

class LocalDataSource(wizardDao: WizardDao) {

    val allWizards: LiveData<List<WizardEntity>> = wizardDao.getAllWizards()
    val favoriteWizards: LiveData<List<WizardEntity>> = wizardDao.getFavoriteWizards()

}