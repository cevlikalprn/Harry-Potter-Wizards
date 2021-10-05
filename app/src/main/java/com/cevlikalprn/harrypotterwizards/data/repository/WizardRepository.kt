package com.cevlikalprn.harrypotterwizards.data.repository

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.LocalDataSource
import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.model.Wizard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WizardRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    val allWizards: LiveData<List<WizardEntity>> = localDataSource.allWizards

    suspend fun insertWizardsToDatabase() {
        withContext(Dispatchers.IO) {
            val wizards = remoteDataSource.getWizards()
            val wizardList = asDatabaseModel(wizards)
            localDataSource.insertAllWizards(wizardList)
        }
    }

    private fun asDatabaseModel(wizards: List<Wizard>): List<WizardEntity> {
        return wizards.map {
            WizardEntity(
                alive = it.alive,
                ancestry = it.ancestry,
                house = it.house,
                image = it.image,
                name = it.name,
                species = it.species,
                yearOfBirth = it.yearOfBirth
            )
        }
    }


}