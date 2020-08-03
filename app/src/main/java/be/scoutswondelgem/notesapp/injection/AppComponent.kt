package be.scoutswondelgem.notesapp.injection

import be.scoutswondelgem.notesapp.injection.modules.*
import org.koin.dsl.module.Module

val appComponent: List<Module> = listOf(databaseModule, networkModule, viewModelModule, repositoryModule)