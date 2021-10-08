package com.cevlikalprn.harrypotterwizards.di

import android.content.Context
import com.cevlikalprn.harrypotterwizards.data.LocalDataSource
import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.data.database.WizardDatabase
import com.cevlikalprn.harrypotterwizards.data.network.HarryPotterService
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.detail.WizardDetailsViewModelFactory
import com.cevlikalprn.harrypotterwizards.favorite.FavoriteWizardsViewModelFactory
import com.cevlikalprn.harrypotterwizards.util.Constants
import com.cevlikalprn.harrypotterwizards.list.WizardListViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterService::class.java)
    }

    private val wizardDao by lazy { WizardDatabase.getInstance(context).wizardDatabaseDao }
    private val localDataSource by lazy { LocalDataSource(wizardDao) }
    private val remoteDataSource by lazy { RemoteDataSource(retrofit) }
    private val wizardRepository by lazy { WizardRepository(remoteDataSource, localDataSource) }
    val wizardListViewModelFactory by lazy { WizardListViewModelFactory(wizardRepository) }
    val wizardDetailsViewModelFactory by lazy { WizardDetailsViewModelFactory(wizardRepository) }
    val favoriteWizardsViewModel by lazy { FavoriteWizardsViewModelFactory(wizardRepository) }
}