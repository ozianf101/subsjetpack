package com.jetpack.submissionsatu.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.jetpack.submissionsatu.R
import com.jetpack.submissionsatu.data.DataKolektif
import com.jetpack.submissionsatu.source.EssIdlingResources
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest : TestCase() {

    private val dummyMovies = DataKolektif.getDataMovies()
    private val dummyTv = DataKolektif.getDataTv()

    @Before
    fun settingUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EssIdlingResources.idlingRes)
    }

    @After
    fun tearingDown() {
        IdlingRegistry.getInstance().unregister(EssIdlingResources.idlingRes)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        onView(withId(R.id.rv_movie)).perform(ViewActions.swipeUp())
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
            click()
        ))
        onView(withId(R.id.tv_title)).perform(ViewActions.swipeUp())
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_desc))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_desc))
        onView(withId(R.id.tv_realase_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_realase_date))
        onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_genre))
        onView(withId(R.id.img_item_photo))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_item_preview))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,
            click()
        ))
        onView(withId(R.id.tv_title)).perform(ViewActions.swipeUp())
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_desc))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_realase_date))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_genre))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_item_photo))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_item_preview))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}