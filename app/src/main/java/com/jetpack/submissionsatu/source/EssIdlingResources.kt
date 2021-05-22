package com.jetpack.submissionsatu.source

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