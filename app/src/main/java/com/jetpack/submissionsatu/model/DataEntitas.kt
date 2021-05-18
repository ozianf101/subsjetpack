package com.jetpack.submissionsatu.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntitas (
    val id : String,
    val title : String,
    val genre : String,
    val rating : Double,
    val overview : String,
    val imgPoster : Int,
    val imgBackground : Int,
    val released : String,
    val runtime : String,
    val language : String,
) : Parcelable