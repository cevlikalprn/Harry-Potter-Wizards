package com.cevlikalprn.harrypotterwizards.data.repository

import androidx.lifecycle.LiveData
import com.cevlikalprn.harrypotterwizards.data.LocalDataSource
import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.data.database.WizardEntity
import com.cevlikalprn.harrypotterwizards.data.database.asDatabaseModel
import com.cevlikalprn.harrypotterwizards.domain.model.Wizard
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class WizardRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {

    private var wizardsFromInternet: List<Wizard>? = null

    val allWizards: LiveData<List<WizardEntity>> = localDataSource.allWizards

    val favoriteWizards: LiveData<List<WizardEntity>> = localDataSource.favoriteWizards

    suspend fun getWizardsFromInternet(): List<Wizard> {
        withContext(Dispatchers.IO) {
            wizardsFromInternet = remoteDataSource.getWizards()
        }
        return wizardsFromInternet!!
    }

    suspend fun insertWizardsToDatabase(wizards: List<Wizard>) {
        withContext(Dispatchers.IO) {
            localDataSource.insertAllWizards(asDatabaseModel(wizards))
        }
    }

    suspend fun updateWizard(wizard: WizardEntity) {
        localDataSource.updateWizard(wizard)
    }
}