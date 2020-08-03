package be.scoutswondelgem.notesapp.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Note(
    @field:Json(name = "id")
    var noteId: Int,
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "content")
    var content: String
)