package com.jetpack.submissionsatu.model

import com.google.gson.annotations.SerializedName

data class TvResponse(
    @SerializedName("results")
    val result: List<DataEntitasTv>
)
