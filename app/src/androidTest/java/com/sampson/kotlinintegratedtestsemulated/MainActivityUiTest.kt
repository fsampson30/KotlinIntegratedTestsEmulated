package com.sampson.kotlinintegratedtestsemulated

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityUiTest {
    @JvmField
    @Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun showSumResultInTextView() {
        activityRule.activity.let { activity ->
            onView(withId(R.id.edit_text)).perform(replaceText("5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(
                matches(
                    withText(
                        activity.getString(
                            R.string.result,
                            5,
                            "15"
                        )
                    )
                )
            )
        }


    }

    @Test
    fun showErrorInTextView() {
        activityRule.activity.let { activity ->
            onView(withId(R.id.edit_text)).perform(ViewActions.replaceText("-5"))
            onView(withId(R.id.button)).perform(click())
            onView(withId(R.id.text_view)).check(matches(withText(activity.getString(R.string.error))))
        }
    }

}