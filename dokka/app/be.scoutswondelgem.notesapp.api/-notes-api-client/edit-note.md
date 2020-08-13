[app](../../index.md) / [be.scoutswondelgem.notesapp.api](../index.md) / [NotesApiClient](index.md) / [editNote](./edit-note.md)

# editNote

`@FormUrlEncoded @PATCH("notes/updateNote") abstract fun editNote(@Field("id") id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Field("title") title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Field("content") content: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`Note`](../../be.scoutswondelgem.notesapp.api.models/-note/index.md)`>`

Edit note

### Parameters

`id` -

`title` -

`content` -

**Return**
Note that was edited

