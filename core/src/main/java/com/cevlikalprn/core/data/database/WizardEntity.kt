package com.cevlikalprn.core.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cevlikalprn.common.Constants.WIZARDS_TABLE
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.cevlikalprn.core.domain.model.Wizard

@Parcelize
@Entity(tableName = WIZARDS_TABLE)
data class WizardEntity(
    @ColumnInfo(name = "alive")
    var alive: Boolean,
    @ColumnInfo(name = "ancestry")
    val ancestry: String,
    @ColumnInfo(name = "house")
    val house: String,
    @ColumnInfo(name = "image")
    val image: String,
    @PrimaryKey
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "year_of_birth")
    val yearOfBirth: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
) : Parcelable


fun asDatabaseModel(wizards: List<Wizard>): List<WizardEntity> {
    return wizards.map {
        WizardEntity(
            alive = it.alive,
            ancestry = it.ancestry,
            house = it.house,
            image = it.image,
            name = it.name,
            species = it.species,
            yearOfBirth = it.yearOfBirth
        )
    }
}