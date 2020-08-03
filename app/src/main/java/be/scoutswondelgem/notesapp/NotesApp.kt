package be.scoutswondelgem.notesapp

import android.app.Application
import org.koin.android.ext.android.startKoin
import be.scoutswondelgem.notesapp.injection.appComponent

class NotesApp : Application() {
        override fun onCreate() {
            super.onCreate()
            startKoin(this, appComponent)
        }
}