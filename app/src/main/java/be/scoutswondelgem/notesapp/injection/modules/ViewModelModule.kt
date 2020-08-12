package be.scoutswondelgem.notesapp.injection.modules

import be.scoutswondelgem.notesapp.viewmodels.NotesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
/**
 * The *viewModelModule*.
 */
val viewModelModule = module {
    viewModel { NotesViewModel(get()) }
}