package com.cevlikalprn.harrypotterwizards.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cevlikalprn.harrypotterwizards.model.Wizard
import com.cevlikalprn.harrypotterwizards.util.Constants.WIZARDS_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = WIZARDS_TABLE)
data class WizardEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wizard_id")
    var wizardId: Int = 0,
    @ColumnInfo(name = "alive")
    var alive: Boolean,
    @ColumnInfo(name = "ancestry")
    val ancestry: String,
    @ColumnInfo(name = "house")
    val house: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "year_of_birth")
    val yearOfBirth: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)