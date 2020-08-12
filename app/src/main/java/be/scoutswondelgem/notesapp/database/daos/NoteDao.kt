package be.scoutswondelgem.notesapp.database.daos

import androidx.room.*
import be.scoutswondelgem.notesapp.database.entities.NoteDataModel
import io.reactivex.Flowable

/**
 * The *NoteDao*.
 *
 * This class makes it possible to access the data from the database;
 * see it as a table in SQL.
 *
 */
@Dao
interface NoteDao {
    @Query("SELECT * from Notes")
    fun getAllNotes(): Flowable<List<NoteDataModel>?>

    @Query("SELECT * from Notes WHERE id =:id")
    fun getNoteById(id: Int): Flowable<NoteDataModel?>

    @Query("DELETE FROM Notes")
    fun deleteAll()

    @Insert
    fun insertAll(notesList: List<NoteDataModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE) //this is the correct usage of the insert, this is because of the generated key
    fun insert(note: NoteDataModel)

    @Update
    fun update(note: NoteDataModel)

    @Delete
    fun deleteNote(note: NoteDataModel)
}