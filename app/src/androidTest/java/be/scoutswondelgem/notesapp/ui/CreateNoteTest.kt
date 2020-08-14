package be.scoutswondelgem.notesapp.ui


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.utils.RecyclerViewMatchers.atPosition
import org.hamcrest.Matchers.not
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
class CreateNoteTest {
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
    fun user_successfully_created_note(){
        onView(withId(R.id.button_addNote)).perform(click())
        onView(withId(R.id.input_title)).perform(typeText("Test note"))
        onView(withId(R.id.input_content)).perform(typeText("This note was created during a test."))
        onView(withId(R.id.button_addNote)).perform(closeSoftKeyboard(), click())
        onView(withId(R.id.notes_list)).perform(scrollToPosition<RecyclerView.ViewHolder>(recyclerView!!.adapter!!.itemCount -1))
            .check(matches(atPosition(recyclerView!!.adapter!!.itemCount -1, hasDescendant(withText("Test note")))))
    }

    @Test
    fun user_cant_create_note_no_title(){
        onView(withId(R.id.button_addNote)).perform(click())
        onView(withId(R.id.input_content)).perform(typeText("This note won't be created, because there is no title."))
        onView(withId(R.id.button_addNote)).perform(closeSoftKeyboard(), click())
            .check(matches(not(isEnabled())))
    }

    @Test
    fun user_cant_create_note_no_content(){
        onView(withId(R.id.button_addNote)).perform(click())
        onView(withId(R.id.input_title)).perform(typeText("Failed note."))
        onView(withId(R.id.button_addNote)).perform(closeSoftKeyboard(), click())
            .check(matches(not(isEnabled())))
    }

}