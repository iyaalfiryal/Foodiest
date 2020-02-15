package com.veronica.idn.foodiest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Locations (
    var title:String,
    var latitude:Double,
    var longitude: Double
):Parcelable