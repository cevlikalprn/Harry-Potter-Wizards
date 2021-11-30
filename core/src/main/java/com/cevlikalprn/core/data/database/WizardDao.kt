package com.cevlikalprn.core.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WizardDao {

    @Query("SELECT * FROM wizards_table")
    fun getAllWizards(): LiveData<List<WizardEntity>>

    @Query("SELECT * FROM wizards_table WHERE is_favorite = 1")
    fun getFavoriteWizards(): LiveData<List<WizardEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllWizards(wizards: List<WizardEntity>)

    @Update
    suspend fun updateWizard(wizard: WizardEntity)

}