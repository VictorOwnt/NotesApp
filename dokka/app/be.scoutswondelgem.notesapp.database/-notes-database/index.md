[app](../../index.md) / [be.scoutswondelgem.notesapp.database](../index.md) / [NotesDatabase](./index.md)

# NotesDatabase

`abstract class NotesDatabase : RoomDatabase`

The *NotesDatabase*.

This class is the room database of the application.

### Constructors

| [&lt;init&gt;](-init-.md) | The *NotesDatabase*.`NotesDatabase()` |

### Properties

| [noteDao](note-dao.md) | the object that makes the notes accessible.`abstract val noteDao: `[`NoteDao`](../../be.scoutswondelgem.notesapp.database.daos/-note-dao/index.md) |

### Companion Object Functions

| [getInstance](get-instance.md) | `fun getInstance(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`NotesDatabase`](./index.md) |

