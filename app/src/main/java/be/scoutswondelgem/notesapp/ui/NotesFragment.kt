package be.scoutswondelgem.notesapp.ui

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.adapters.NotesAdapter
import be.scoutswondelgem.notesapp.databinding.FragmentNotesBinding
import be.scoutswondelgem.notesapp.viewmodels.NotesViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_notes.view.*
import kotlinx.android.synthetic.main.notes_list.*
import org.koin.android.viewmodel.ext.android.viewModel
/**
 * The *createNoteFragment*.
 *
 * This class is bound to the screen for displaying notes.
 */
class NotesFragment :
    Fragment() {
    //Voor creatie NotesFragment
    companion object {
        @JvmStatic
        fun newInstance() = NotesFragment()
    }

    //UI elementen:
    private lateinit var addNotesTextView: TextView
    private lateinit var addNotesButton: FloatingActionButton
    private lateinit var notesRecyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var noNotesTextView: TextView

    //Injecteren:
    private val notesViewModel by viewModel<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentNotesBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_notes, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.notesViewModel = notesViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNotesTextView = view.addNote
        addNotesButton = view.button_addNote
        noNotesTextView = view.noNotesYet
        notesViewModel.fetchNotesFromApi()
        fillListView()
        addNotesButton.setOnClickListener {
            activity?.supportFragmentManager!!.beginTransaction()
                .replace(R.id.main_content_container, CreateNoteFragment.newInstance(), "CreateNoteFragment")
                .setTransition((FragmentTransaction.TRANSIT_FRAGMENT_OPEN))
                .addToBackStack("NotesFragment")
                .commit()
        }
    }

    private fun fillListView() { 
        notesRecyclerView = notes_list
        linearLayoutManager = LinearLayoutManager(activity)
        notesRecyclerView.layoutManager = linearLayoutManager
        val adapter = NotesAdapter(emptyList())
        adapter.onItemClick = { note ->
            activity?.supportFragmentManager!!.beginTransaction()
                .replace(R.id.main_content_container, EditNoteFragment.newInstance(note.noteId), "EditNoteFragment")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("NotesFragment")
                .commit()
        }
        adapter.onItemClick2 = { note ->
            val dialogBuilder = AlertDialog.Builder(activity!!)
                .setCancelable(true)
                .setNegativeButton("No") {
                    dialog, id -> dialog.dismiss()
                }
                .setPositiveButton("Yes") {
                   dialog, id -> dialog.dismiss()
                    val deleted = notesViewModel.deleteNote(note)
                    if(deleted) {
                        Toast.makeText(activity, "Note deleted successfully" , Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, "Something went wrong while deleting the note" , Toast.LENGTH_SHORT).show()
                    }
                }
            val alert = dialogBuilder.create()
            alert.setTitle("Are you sure you want to remove this note ?")
            alert.show()
        }
        adapter.onItemClick3 = { note ->
            val clipboardManager = context!!.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", note.content)
            clipboardManager.setPrimaryClip(clipData)

            Toast.makeText(activity, "Note copied to clipboard" , Toast.LENGTH_SHORT).show()
        }
        notesRecyclerView.adapter = adapter


        notesViewModel.getNotesfromDatabase()?.let {
            notesViewModel.getNotesfromDatabase()!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ notesList ->
                    Logger.i("Getting data from database")
                    if (notesList.isNotEmpty()) {
                        noNotesTextView.visibility = View.GONE
                        adapter.updateNotes(notesList)
                    } else if (notesList.isEmpty()) {
                        noNotesTextView.visibility = View.VISIBLE
                        adapter.updateNotes(notesList)
                    }
                }, { error -> Logger.e(error.message!!) })
        }
    }
}