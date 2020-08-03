package be.scoutswondelgem.notesapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteDataModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var noteId: Int,
    var title: String,
    var content: String
)