package be.scoutswondelgem.notesapp.injection.modules

import android.content.Context
import be.scoutswondelgem.notesapp.database.NotesDatabase
import be.scoutswondelgem.notesapp.database.daos.NoteDao
import org.koin.dsl.module.module

val databaseModule = module {
    single { provideDatabase(get()) }
    single { provideNotesDao(get()) }
}

fun provideDatabase(applicationContext: Context): NotesDatabase {
    return NotesDatabase.getInstance(applicationContext)
}

fun provideNotesDao(notesDatabase: NotesDatabase): NoteDao {
    return notesDatabase.noteDao
}