package com.cevlikalprn.harrypotterwizards.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WizardDao {

    @Query("SELECT * FROM wizards_table")
    fun getAllWizards(): LiveData<List<WizardEntity>>

    @Query("SELECT * FROM wizards_table WHERE is_favorite = 1")
    fun getFavoriteWizards(): LiveData<List<WizardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllWizards(wizards: List<WizardEntity>)

}