package com.anikulki.nasa.ui.grid

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.anikulki.nasa.R
import com.anikulki.nasa.ui.MainActivity
import com.anikulki.nasa.utils.SampleData
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class GridFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private val itemPositionInTest = 25

    private val fakeList = SampleData.imagesList[itemPositionInTest]

    @Test
    fun isGridFragmentVisible_onAppLaunch(){
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun selectGridItem_isImagePagerFragmentVisible(){
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<NasaImageAdapter.ImageHolder>(itemPositionInTest, click()))

        onView(withId(R.id.tvTitle)).check(matches(withText(fakeList.title)))
    }

    @Test
    fun backNavigationToGridFragment(){
        onView(withId(R.id.recyclerView))
            .perform(actionOnItemAtPosition<NasaImageAdapter.ImageHolder>(itemPositionInTest, click()))

        onView(withId(R.id.tvTitle)).check(matches(withText(fakeList.title)))

        pressBack()

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}