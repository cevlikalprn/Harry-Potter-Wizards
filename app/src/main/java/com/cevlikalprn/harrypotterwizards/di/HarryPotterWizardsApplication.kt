package com.cevlikalprn.harrypotterwizards.di

import android.app.Application

class HarryPotterWizardsApplication : Application() {

    val appContainer by lazy { AppContainer(this@HarryPotterWizardsApplication) }

}