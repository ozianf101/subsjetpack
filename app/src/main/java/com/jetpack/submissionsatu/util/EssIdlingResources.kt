package com.jetpack.submissionsatu.util

import androidx.test.espresso.idling.CountingIdlingResource

object EssIdlingResources {
    private const val RESOURCE = "GLOBAL"
    val idlingRes = CountingIdlingResource(RESOURCE)

    fun increment() {
        idlingRes.increment()
    }

    fun decrement() {
        idlingRes.decrement()
    }
}