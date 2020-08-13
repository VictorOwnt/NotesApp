[app](../../index.md) / [be.scoutswondelgem.notesapp.database.daos](../index.md) / [NoteDao](./index.md)

# NoteDao

`interface NoteDao`

The *NoteDao*.

This class makes it possible to access the data from the database;
see it as a table in SQL.

### Functions

| [deleteAll](delete-all.md) | `abstract fun deleteAll(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deleteNote](delete-note.md) | `abstract fun deleteNote(note: `[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAllNotes](get-all-notes.md) | `abstract fun getAllNotes(): Flowable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>?>` |
| [getNoteById](get-note-by-id.md) | `abstract fun getNoteById(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Flowable<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`?>` |
| [insert](insert.md) | `abstract fun insert(note: `[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [insertAll](insert-all.md) | `abstract fun insertAll(notesList: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [update](update.md) | `abstract fun update(note: `[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

