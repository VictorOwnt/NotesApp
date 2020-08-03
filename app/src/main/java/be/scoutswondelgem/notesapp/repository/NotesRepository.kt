package be.scoutswondelgem.notesapp.repository

import be.scoutswondelgem.notesapp.api.NotesApiClient
import be.scoutswondelgem.notesapp.database.daos.NoteDao
import be.scoutswondelgem.notesapp.database.entities.NoteDataModel
import com.orhanobut.logger.Logger
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class NotesRepository(private val notesApiClient: NotesApiClient, private val dao: NoteDao) {
    //RxJava
    private var disposables = CompositeDisposable()

    fun getDataFromApi() {
        disposables.add(
            notesApiClient.getNotes()
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { notesList ->
                        Logger.i("Fetching notes from api")
                        val dbNotesList: MutableList<NoteDataModel> = ArrayList()
                        for (note in notesList) {
                            if (!note.content.isNullOrEmpty()) {
                                dbNotesList.add(NoteDataModel(note.noteId, note.title, note.content))
                            }
                        }
                        dao.deleteAll()
                        dao.insertAll(dbNotesList)
                    },
                    { error ->
                        Logger.e(
                            (error as HttpException).response()!!.errorBody()!!.string()
                        )
                    }
                )
        )
    }

    fun getDataFromDataBase(): Flowable<List<NoteDataModel>?> {
        return dao.getAllNotes()
    }

    fun getNoteById(noteId: Int): Flowable<NoteDataModel?> {
        return dao.getNoteById(noteId)
    }

    fun deleteNote(note: NoteDataModel): Boolean {
        var response = false
        disposables.add(
            notesApiClient.deleteNote(note.noteId)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { deleted ->
                        Logger.i("Deleting note from api")
                        if (deleted) {
                            Logger.i("Deleting note from database")
                            dao.deleteNote(note)
                            response = true
                        }
                    },
                    { error ->
                        Logger.e(
                            (error as HttpException).response()!!.errorBody()!!.string()
                        )
                        response = false
                    }
                )
        )
        return response
    }

    fun createNote(title: String, content: String): Boolean{
        var response = false
        disposables.add(
            notesApiClient.createNote(title, content)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { note ->
                        Logger.i("Adding note in Api")
                        if(!note.content.isNullOrEmpty() && !note.title.isNullOrEmpty()) {
                            Logger.i("Adding note to database")
                            dao.insert(NoteDataModel(note.noteId, note.title, note.content))
                            response = true
                        }
                    },
                    { error ->
                        Logger.e(
                            (error as HttpException).response()!!.errorBody()!!.string()
                        )
                        response = false
                    }
                )
            )
        return response
    }

    fun editNote(noteId: Int, title: String, content: String): Boolean{
        var response = false
        disposables.add(
            notesApiClient.editNote(noteId, title, content)
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { note ->
                        Logger.i("Editing note in Api")
                        if(!note.content.isNullOrEmpty() && !note.title.isNullOrEmpty()) {
                            Logger.i("Editing note in database")
                            dao.update(NoteDataModel(note.noteId, note.title, note.content))
                            response = true
                        }
                    },
                    { error ->
                        Logger.e(
                            (error as HttpException).response()!!.errorBody()!!.string()
                        )
                        response = false
                    }
                )
        )
        return response
    }

    fun onCleared() {
        disposables.clear()
    }
}