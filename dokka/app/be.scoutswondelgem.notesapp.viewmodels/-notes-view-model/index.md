[app](../../index.md) / [be.scoutswondelgem.notesapp.viewmodels](../index.md) / [NotesViewModel](./index.md)

# NotesViewModel

`class NotesViewModel : ViewModel`

The *NotesViewModel*.

### Constructors

| [&lt;init&gt;](-init-.md) | The *NotesViewModel*.`NotesViewModel(notesRepository: `[`NotesRepository`](../../be.scoutswondelgem.notesapp.repository/-notes-repository/index.md)`)` |

### Properties

| [contentEnabled](content-enabled.md) | `val contentEnabled: MutableLiveData<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [loadingVisibility](loading-visibility.md) | `val loadingVisibility: MutableLiveData<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |

### Functions

| [createNote](create-note.md) | `fun createNote(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [deleteNote](delete-note.md) | `fun deleteNote(note: `[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [editNote](edit-note.md) | `fun editNote(noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [fetchNotesFromApi](fetch-notes-from-api.md) | `fun fetchNotesFromApi(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getNoteById](get-note-by-id.md) | `fun getNoteById(noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Flowable<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>?` |
| [getNotesfromDatabase](get-notesfrom-database.md) | `fun getNotesfromDatabase(): Flowable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>>?` |
| [onCleared](on-cleared.md) | `fun onCleared(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

