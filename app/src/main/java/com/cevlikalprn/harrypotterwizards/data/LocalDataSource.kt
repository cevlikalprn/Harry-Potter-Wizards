package com.cevlikalprn.harrypotterwizards.data

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.database.WizardDao
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity

class LocalDataSource(private val wizardDao: WizardDao) {

    val allWizards: LiveData<List<WizardEntity>> = wizardDao.getAllWizards()
    val favoriteWizards: LiveData<List<WizardEntity>> = wizardDao.getFavoriteWizards()

    suspend fun insertAllWizards(wizards: List<WizardEntity>) {
        wizardDao.insertAllWizards(wizards)
    }

}