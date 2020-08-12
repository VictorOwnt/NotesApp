package be.scoutswondelgem.notesapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A *NoteDataModel*.
 *
 * This class represents the note locally;
 * notes that come from the api will be converted to objects of this class so they fit in the room database.
 *
 * @property noteId the id of a note.
 * @property title the title of a note.
 * @property content the content of a note.
 */
@Entity(tableName = "Notes")
data class NoteDataModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var noteId: Int,
    var title: String,
    var content: String
)