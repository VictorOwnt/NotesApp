package be.scoutswondelgem.notesapp.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A *note*.
 *
 * This class is the same as the Note class from the API;
 * the json responses will be converted into objects from this class.
 *
 * @property noteId the id of a note.
 * @property title the title of a note.
 * @property content the content of a note.
 */

@JsonClass(generateAdapter = true)
data class Note(
    @field:Json(name = "id")
    var noteId: Int,
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "content")
    var content: String
)