package be.scoutswondelgem.notesapp.ui

import androidx.test.core.app.ActivityScenario
import org.junit.Test


internal class MainActivityTest{

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }
}