[app](../index.md) / [be.scoutswondelgem.notesapp.injection.modules](./index.md)

## Package be.scoutswondelgem.notesapp.injection.modules

### Properties

| [databaseModule](database-module.md) | The *databaseModule*.`val databaseModule: Module` |
| [networkModule](network-module.md) | The *networkModule*.`val networkModule: Module` |
| [repositoryModule](repository-module.md) | The *repositoryModule*.`val repositoryModule: Module` |
| [viewModelModule](view-model-module.md) | The *viewModelModule*.`val viewModelModule: Module` |

### Functions

| [provideDatabase](provide-database.md) | `fun provideDatabase(applicationContext: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`NotesDatabase`](../be.scoutswondelgem.notesapp.database/-notes-database/index.md) |
| [provideNotesApi](provide-notes-api.md) | `fun provideNotesApi(retrofit: Retrofit): `[`NotesApiClient`](../be.scoutswondelgem.notesapp.api/-notes-api-client/index.md) |
| [provideNotesDao](provide-notes-dao.md) | `fun provideNotesDao(notesDatabase: `[`NotesDatabase`](../be.scoutswondelgem.notesapp.database/-notes-database/index.md)`): `[`NoteDao`](../be.scoutswondelgem.notesapp.database.daos/-note-dao/index.md) |
| [provideNotesRepository](provide-notes-repository.md) | `fun provideNotesRepository(apiClient: `[`NotesApiClient`](../be.scoutswondelgem.notesapp.api/-notes-api-client/index.md)`, dao: `[`NoteDao`](../be.scoutswondelgem.notesapp.database.daos/-note-dao/index.md)`): `[`NotesRepository`](../be.scoutswondelgem.notesapp.repository/-notes-repository/index.md) |
| [provideOkHttpClient](provide-ok-http-client.md) | `fun provideOkHttpClient(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): OkHttpClient` |
| [provideRetrofit](provide-retrofit.md) | `fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit` |

