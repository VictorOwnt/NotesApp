package be.scoutswondelgem.notesapp.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.scoutswondelgem.notesapp.database.entities.NoteDataModel
import be.scoutswondelgem.notesapp.repository.NotesRepository
import com.orhanobut.logger.Logger
import io.reactivex.Flowable
/**
 * The *NotesViewModel*.
 */
class NotesViewModel(private val notesRepository: NotesRepository):  ViewModel() {
    //LoadingVisibility:
    val loadingVisibility = MutableLiveData<Int>()
    val contentEnabled = MutableLiveData<Boolean>()

    init {
        loadingVisibility.value = View.GONE
        contentEnabled.value = true
    }

    // fill room database with data
    fun fetchNotesFromApi() {
        try {
            notesRepository.getDataFromApi()
        } catch (e: Exception) {
            onRetrieveError(e)
        }
    }

    // Retrieve data from room database
    fun getNotesfromDatabase(): Flowable<List<NoteDataModel>>? {
        return try {
            onRetrieveStart()
            notesRepository.getDataFromDataBase().switchMap { data -> Flowable.just(data) }
        } catch (e : Exception) {
            onRetrieveError(e)
            null
        } finally {
            onRetrieveFinish()
        }
    }

    fun getNoteById(noteId: Int): Flowable<NoteDataModel>? {
        return try {
            onRetrieveStart()
            notesRepository.getNoteById(noteId).switchMap { data -> Flowable.just(data) }
        } catch (e : Exception) {
            onRetrieveError(e)
            null
        } finally {
            onRetrieveFinish()
        }
    }

    fun deleteNote(note: NoteDataModel): Boolean {
        return try {
            onRetrieveStart()
            notesRepository.deleteNote(note)
            true
        } catch (e: Exception) {
            onRetrieveError(e)
            false
        } finally {
            onRetrieveFinish()
        }
    }

    fun createNote(title: String, content: String): Boolean {
        return try {
            onRetrieveStart()
            notesRepository.createNote(title, content)
            true
        } catch (e: Exception) {
            onRetrieveError(e)
            false
        } finally {
            onRetrieveFinish()
        }
    }

    fun editNote(noteId: Int, title: String, content: String): Boolean {
        return try {
            onRetrieveStart()
            notesRepository.editNote(noteId, title, content)
            true
        } catch (e: Exception) {
            onRetrieveError(e)
            false
        } finally {
            onRetrieveFinish()
        }
    }

    private fun onRetrieveError(error: Throwable) {
        Logger.e(error.message!!)
    }

    private fun onRetrieveStart() {
        loadingVisibility.value = View.VISIBLE
        contentEnabled.value = false
    }

    private fun onRetrieveFinish() {
        loadingVisibility.value = View.GONE
        contentEnabled.value = true
    }


    override fun onCleared() {
        super.onCleared()
        notesRepository.onCleared()
    }
}