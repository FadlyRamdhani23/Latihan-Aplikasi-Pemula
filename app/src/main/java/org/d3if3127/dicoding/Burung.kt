package org.d3if3127.dicoding

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Burung(
    val name: String,
    val description: String,
    val photo: Int,
    val makanan :String
) : Parcelable