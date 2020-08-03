package be.scoutswondelgem.notesapp.api

import be.scoutswondelgem.notesapp.api.models.Note
import io.reactivex.Single
import retrofit2.http.*

interface NotesApiClient {

    /**
     * Gets notes
     *
     * @return notes
     */
    @GET("notes")
    fun getNotes(): Single<List<Note>>

    /**
     * Gets note by id
     *
     * @param id
     * @return Note with requested id
     */
    @GET("notes/{id}")
    fun getNoteById(@Path("id") id: Int): Single<Note>

    /**
     * Creates a new note
     *
     * @param title
     * @param content
     * @return Note that was created
     */
    @FormUrlEncoded
    @POST("notes/create")
    fun createNote(
        @Field("title") title: String,
        @Field("content") content: String
    ): Single<Note>

    /**
     * Edit note
     *
     * @param id
     * @param title
     * @param content
     * @return Note that was edited
     */
    @FormUrlEncoded
    @PATCH("notes/updateNote")
    fun editNote(@Field("id") id: Int,
                 @Field("title") title: String,
                 @Field("content") content: String): Single<Note>

    /**
     * Delete note
     *
     * @param id
     * @return boolean
     */
    @DELETE("notes/delete/{id}")
    fun deleteNote(@Path("id") id: Int) : Single<Boolean>
}
