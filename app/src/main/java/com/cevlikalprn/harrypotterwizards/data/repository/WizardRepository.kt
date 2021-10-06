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

    val favoriteWizards: LiveData<List<WizardEntity>> = localDataSource.favoriteWizards

    suspend fun insertWizardsToDatabase() {
        withContext(Dispatchers.IO) {
            val wizards = remoteDataSource.getWizards()
            localDataSource.insertAllWizards(asDatabaseModel(wizards))
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

    suspend fun updateWizard(wizard: WizardEntity) {
        localDataSource.updateWizard(wizard)
    }
}