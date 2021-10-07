package com.cevlikalprn.harrypotterwizards.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cevlikalprn.harrypotterwizards.util.Constants.DATABASE_NAME

@Database(entities = [WizardEntity::class], version = 1)
abstract class WizardDatabase : RoomDatabase() {

    abstract val wizardDatabaseDao: WizardDao

    companion object {
        @Volatile
        private var INSTANCE: WizardDatabase? = null

        fun getInstance(context: Context): WizardDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        WizardDatabase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}