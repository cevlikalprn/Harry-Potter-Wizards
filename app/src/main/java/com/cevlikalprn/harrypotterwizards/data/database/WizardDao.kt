package com.cevlikalprn.harrypotterwizards.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface WizardDao {

    @Query("SELECT * FROM wizard_table")
    fun getAllWizards(): LiveData<List<WizardEntity>>
}