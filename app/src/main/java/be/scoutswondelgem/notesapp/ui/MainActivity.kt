package be.scoutswondelgem.notesapp.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import be.scoutswondelgem.notesapp.R
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.app_bar_main.*
/**
 * The *MainActivity*.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR

        title = "My Notes"
        setContentView(R.layout.activity_main)

        //Toolbar menu
        setSupportActionBar(toolbar)

        // Set logger
        Logger.addLogAdapter(AndroidLogAdapter())

        // Navigate to right fragment
        this.supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_content_container, NotesFragment.newInstance(), "NotesFragment")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack("NotesFragment")
            .commit()
    }
}