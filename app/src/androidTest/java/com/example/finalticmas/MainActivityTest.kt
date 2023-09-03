package com.example.finalticmas

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

internal class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)



    fun setUp() {
    }


    fun tearDown() {
    }

    @Test
    fun mainActivity_comparar(){
        Espresso.onView(
            ViewMatchers.withId(R.id.button2)
        ).perform((
                ViewActions.click()
                )


        )
        Espresso.onView(
            ViewMatchers.withId(R.id.Textoresultado)

        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Iguales")
            )
        )
    }
}