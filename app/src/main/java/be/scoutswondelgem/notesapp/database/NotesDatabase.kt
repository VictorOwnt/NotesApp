package be.scoutswondelgem.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.scoutswondelgem.notesapp.database.daos.NoteDao
import be.scoutswondelgem.notesapp.database.entities.NoteDataModel

/**
 * The *NotesDatabase*.
 *
 * This class is the room database of the application.
 *
 * @property noteDao the object that makes the notes accessible.
 */
@Database(entities = [NoteDataModel::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        "notes_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}