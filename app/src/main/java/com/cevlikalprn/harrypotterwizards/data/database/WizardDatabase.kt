package com.cevlikalprn.harrypotterwizards.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WizardEntity::class], version = 1)
abstract class WizardDatabase : RoomDatabase() {

    abstract val wizardDatabaseDao: WizardDao

}