package com.cevlikalprn.harrypotterwizards.di

import android.content.Context
import androidx.room.Room
import com.cevlikalprn.harrypotterwizards.data.database.WizardDao
import com.cevlikalprn.harrypotterwizards.data.database.WizardDatabase
import com.cevlikalprn.harrypotterwizards.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WizardDatabase {
        return Room.databaseBuilder(
            context,
            WizardDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(database: WizardDatabase): WizardDao {
        return database.wizardDatabaseDao
    }

}