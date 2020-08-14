package be.scoutswondelgem.notesapp.ui

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.utils.RecyclerViewMatchers.atPosition
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
class CopyNoteTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule((MainActivity::class.java))

    private var recyclerView : RecyclerView? = null
    private var clipboardManager: ClipboardManager? = null

    @Before
    fun setUp() {
        val intent: Intent = Intent()
        rule.launchActivity(intent)
        recyclerView = rule.activity.findViewById(R.id.notes_list)
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        clipboardManager = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    @Test
    fun user_successfully_copy_last_note(){
        onView(withId(R.id.notes_list))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(recyclerView!!.adapter!!.itemCount - 1))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(recyclerView!!.adapter!!.itemCount - 1, clickChildViewWithId(R.id.button_copyNoteContent)))
        onView(withId(R.id.notes_list)).perform(scrollToPosition<RecyclerView.ViewHolder>(recyclerView!!.adapter!!.itemCount -1))
            .check(matches(atPosition(recyclerView!!.adapter!!.itemCount - 1, hasDescendant(withText(clipboardManager!!.primaryClip!!.getItemAt(0).text.toString())))))

    }
}