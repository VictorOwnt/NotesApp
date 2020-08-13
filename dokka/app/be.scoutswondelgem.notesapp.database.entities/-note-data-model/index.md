[app](../../index.md) / [be.scoutswondelgem.notesapp.database.entities](../index.md) / [NoteDataModel](./index.md)

# NoteDataModel

`data class NoteDataModel`

A *NoteDataModel*.

This class represents the note locally;
notes that come from the api will be converted to objects of this class so they fit in the room database.

### Constructors

| [&lt;init&gt;](-init-.md) | A *NoteDataModel*.`NoteDataModel(noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)` |

### Properties

| [content](content.md) | the content of a note.`var content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [noteId](note-id.md) | the id of a note.`var noteId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [title](title.md) | the title of a note.`var title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

