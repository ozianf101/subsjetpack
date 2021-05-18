package com.jetpack.submissionsatu.adapter

import com.jetpack.submissionsatu.model.DataEntitas

interface ContentCallback {
    fun onItemClicked(data: DataEntitas)
}