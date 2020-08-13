[app](../../index.md) / [be.scoutswondelgem.notesapp.repository](../index.md) / [NotesRepository](./index.md)

# NotesRepository

`class NotesRepository`

The *NotesRepository*.

This class fixes all interaction with the api and the room database.

### Constructors

| [&lt;init&gt;](-init-.md) | The *NotesRepository*.`NotesRepository(notesApiClient: `[`NotesApiClient`](../../be.scoutswondelgem.notesapp.api/-notes-api-client/index.md)`, dao: `[`NoteDao`](../../be.scoutswondelgem.notesapp.database.daos/-note-dao/index.md)`)` |

### Functions

| [createNote](create-note.md) | `fun createNote(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [deleteNote](delete-note.md) | `fun deleteNote(note: `[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [editNote](edit-note.md) | `fun editNote(noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getDataFromApi](get-data-from-api.md) | `fun getDataFromApi(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDataFromDataBase](get-data-from-data-base.md) | `fun getDataFromDataBase(): Flowable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>?>` |
| [getNoteById](get-note-by-id.md) | `fun getNoteById(noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Flowable<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`?>` |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

