package be.scoutswondelgem.notesapp.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.utils.ViewActions.clickChildViewWithId

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DeleteNoteTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule((MainActivity::class.java))

    private var recyclerView : RecyclerView? = null

    @Before
    fun setUp() {
        val intent: Intent = Intent()
        rule.launchActivity(intent)
        recyclerView = rule.activity.findViewById(R.id.notes_list)
    }

    @Test
    fun user_successfully_deleted_last_note(){
        onView(withId(R.id.notes_list))
            .perform(RecyclerViewActions.scrollToPosition<ViewHolder>(recyclerView!!.adapter!!.itemCount - 1))
            .perform(actionOnItemAtPosition<ViewHolder>(recyclerView!!.adapter!!.itemCount - 1, clickChildViewWithId(R.id.button_removeNote)))
        onView(withText("Yes")).inRoot(isDialog()).check(matches(isDisplayed())).perform(click())
    }

    @Test
    fun user_canceled_delete_last_note(){
        onView(withId(R.id.notes_list))
            .perform(RecyclerViewActions.scrollToPosition<ViewHolder>(recyclerView!!.adapter!!.itemCount - 1))
            .perform(actionOnItemAtPosition<ViewHolder>(recyclerView!!.adapter!!.itemCount - 1, clickChildViewWithId(R.id.button_removeNote)))
        onView(withText("No")).inRoot(isDialog()).check(matches(isDisplayed())).perform(click())
    }

}