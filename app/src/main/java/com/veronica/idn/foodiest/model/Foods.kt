package com.veronica.idn.foodiest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Foods(
    var name: String,
    var address: String,
    var kind: String,
    var des : String,
    var price : String,
    var images: Int

) : Parcelable