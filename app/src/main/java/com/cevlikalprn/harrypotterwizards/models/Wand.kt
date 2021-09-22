package com.cevlikalprn.harrypotterwizards.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wand(
    @SerializedName("core")
    val core: String,
    @SerializedName("length")
    val length: String,
    @SerializedName("wood")
    val wood: String
): Parcelable