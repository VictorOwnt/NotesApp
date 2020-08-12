package be.scoutswondelgem.notesapp.injection

import be.scoutswondelgem.notesapp.injection.modules.*
import org.koin.dsl.module.Module
/**
 * The *appComponent*.
 *
 * This component contains all modules that will be injected.
 */
val appComponent: List<Module> = listOf(databaseModule, networkModule, viewModelModule, repositoryModule)