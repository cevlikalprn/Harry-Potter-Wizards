package com.cevlikalprn.harrypotterwizards.di

import com.cevlikalprn.harrypotterwizards.data.RemoteDataSource
import com.cevlikalprn.harrypotterwizards.data.network.HarryPotterService
import com.cevlikalprn.harrypotterwizards.data.repository.WizardRepository
import com.cevlikalprn.harrypotterwizards.util.Constants
import com.cevlikalprn.harrypotterwizards.viewmodel.WizardListViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val retrofit =  Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HarryPotterService::class.java)

    private val remoteDataSource = RemoteDataSource(retrofit)

    private val wizardRepository = WizardRepository(remoteDataSource)

    val wizardListViewModelFactory = WizardListViewModelFactory(wizardRepository)
}