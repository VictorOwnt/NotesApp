package be.scoutswondelgem.notesapp.injection.modules

import be.scoutswondelgem.notesapp.api.NotesApiClient
import be.scoutswondelgem.notesapp.database.daos.NoteDao
import be.scoutswondelgem.notesapp.repository.NotesRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single { provideNotesRepository(get(), get()) }
}

fun provideNotesRepository(apiClient: NotesApiClient, dao: NoteDao): NotesRepository {
    return NotesRepository(apiClient, dao)
}
