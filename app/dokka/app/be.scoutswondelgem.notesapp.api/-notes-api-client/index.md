[app](../../index.md) / [be.scoutswondelgem.notesapp.api](../index.md) / [NotesApiClient](./index.md)

# NotesApiClient

`interface NotesApiClient`

The *NotesApiClient*.

This class contains all requests that can be made to the Api.

### Functions

| [createNote](create-note.md) | Creates a new note`abstract fun createNote(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`Note`](../../be.scoutswondelgem.notesapp.api.models/-note/index.md)`>` |
| [deleteNote](delete-note.md) | Delete note`abstract fun deleteNote(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [editNote](edit-note.md) | Edit note`abstract fun editNote(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`Note`](../../be.scoutswondelgem.notesapp.api.models/-note/index.md)`>` |
| [getNoteById](get-note-by-id.md) | Gets note by id`abstract fun getNoteById(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`Note`](../../be.scoutswondelgem.notesapp.api.models/-note/index.md)`>` |
| [getNotes](get-notes.md) | Gets notes`abstract fun getNotes(): Single<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Note`](../../be.scoutswondelgem.notesapp.api.models/-note/index.md)`>>` |

