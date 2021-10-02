package com.cevlikalprn.harrypotterwizards.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.util.Constants.WIZARDS_TABLE

@Entity(tableName = WIZARDS_TABLE)
data class WizardEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wizard_id")
    var wizardId: Int = 0,
    @ColumnInfo(name = "wizard")
    val wizard: Wizard,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)