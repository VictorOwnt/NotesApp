[app](../../index.md) / [be.scoutswondelgem.notesapp.adapters](../index.md) / [NotesAdapter](./index.md)

# NotesAdapter

`class NotesAdapter : Adapter<NotesViewHolder>`

The *NotesAdapter*.

This class is used to display the *notes*.

### Types

| [NotesViewHolder](-notes-view-holder/index.md) | Provide a reference to the type of views that you are using (custom ViewHolder)`inner class NotesViewHolder : ViewHolder` |

### Constructors

| [&lt;init&gt;](-init-.md) | The *NotesAdapter*.`NotesAdapter(notesList: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>)` |

### Properties

| [onItemClick](on-item-click.md) | is a clickhandler.`var onItemClick: ((`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?` |
| [onItemClick2](on-item-click2.md) | is a clickhandler.`var onItemClick2: ((`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?` |
| [onItemClick3](on-item-click3.md) | is a clickhandler.`var onItemClick3: ((`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`)?` |

### Functions

| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(viewHolder: NotesViewHolder, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(viewGroup: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): NotesViewHolder` |
| [updateNotes](update-notes.md) | `fun updateNotes(updatedNotesList: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`NoteDataModel`](../../be.scoutswondelgem.notesapp.database.entities/-note-data-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

