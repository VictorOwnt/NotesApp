package be.scoutswondelgem.notesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.database.entities.NoteDataModel
import kotlinx.android.synthetic.main.row_note.view.*

class NotesAdapter(private var notesList: List<NoteDataModel>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    //for the transaction of fragments
    var onItemClick: ((NoteDataModel) -> Unit)? = null
    var onItemClick2: ((NoteDataModel) -> Unit)? = null
    var onItemClick3: ((NoteDataModel) -> Unit)? = null


    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    inner class NotesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var noteId : TextView = view.noteId
        var noteContent: TextView = view.noteContent
        var editNoteButton: ImageButton = view.button_editNote
        var removeNoteButton: ImageButton = view.button_removeNote
        var copyNoteContentButton: ImageButton = view.button_copyNoteContent

        init {
            editNoteButton.setOnClickListener{
                onItemClick?.invoke(notesList[adapterPosition])
            }
            removeNoteButton.setOnClickListener{
                onItemClick2?.invoke(notesList[adapterPosition])
            }
            copyNoteContentButton.setOnClickListener{
                onItemClick3?.invoke(notesList[adapterPosition])
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NotesViewHolder {
        // Create a new view.
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_note, viewGroup, false)
        return NotesViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: NotesViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        val note: NoteDataModel = notesList[position]
        /* TODO misschien iets met completen van note?
        if(order.status.status == "Bezorgd") {
            viewHolder.removeOrderButton.visibility = View.GONE
            viewHolder.editOrderButton.setImageResource(R.drawable.ic_search_orange_24dp)
        }*/
        viewHolder.noteId.text = note.title
        viewHolder.noteContent.text = note.content
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = notesList.size

    // Update data
    fun updateNotes(updatedNotesList : List<NoteDataModel>){
        notesList = updatedNotesList
        notifyDataSetChanged()
    }
}