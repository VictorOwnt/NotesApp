package be.scoutswondelgem.notesapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import be.scoutswondelgem.notesapp.R
import be.scoutswondelgem.notesapp.databinding.FragmentEditNoteBinding
import be.scoutswondelgem.notesapp.viewmodels.NotesViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_edit_note.view.*
import org.koin.android.viewmodel.ext.android.viewModel
/**
 * The *EditNoteFragment*.
 *
 * This class is bound to the screen for editing a new note.
 */
private const val ARG_NOTE_ID = "noteId"
private const val ARG_NOTE_CONTENT = "content"
private const val ARG_NOTE_TITLE = "title"

class EditNoteFragment: Fragment() {
    private var noteId: Int? = null
    private var noteTitle: String? = null
    private var noteContent: String? = null

    //Voor creatie EditNoteFragment
    companion object {
        @JvmStatic
        fun newInstance(noteId: Int?) = EditNoteFragment().apply {
            arguments = Bundle().apply {
                if (noteId != null) {
                    putInt(ARG_NOTE_ID, noteId)
                }
            }
        }
    }

    //UI elementen:
    private lateinit var editNoteButton: Button
    private lateinit var titleInputLayout: TextInputLayout
    private lateinit var titleInput: TextInputEditText
    private lateinit var contentInputLayout: TextInputLayout
    private lateinit var contentInput: TextInputEditText

    //Injecteren:
    private val notesViewModel by viewModel<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            noteId = it.getInt(ARG_NOTE_ID)
        }
        if (savedInstanceState != null) {
            noteTitle = savedInstanceState.getString(ARG_NOTE_TITLE)
            noteContent = savedInstanceState.getString(ARG_NOTE_CONTENT)
        }
    }

    override fun onResume() {
        super.onResume()
        activity!!.title = resources.getString(R.string.edit_note)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ARG_NOTE_TITLE, titleInput.text.toString())
        outState.putString(ARG_NOTE_CONTENT, contentInput.text.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEditNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_note, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.notesViewModel = notesViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editNoteButton = view.button_addNote
        titleInputLayout = view.inputLayout_title
        titleInput = view.input_title
        contentInputLayout = view.inputLayout_content
        contentInput = view.input_content
        titleInput.addTextChangedListener(titleWatcher)
        contentInput.addTextChangedListener(contentWatcher)
        editNoteButton.setOnClickListener {
            editNote()
        }
        fillNoteView(noteId!!)
    }

    private fun fillNoteView(noteId: Int) {
        if(noteTitle == null && noteContent == null) {
            notesViewModel.getNoteById(noteId)?.let {
                notesViewModel.getNoteById(noteId)!!
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ note ->
                        Logger.i("Getting note by id from database")
                        titleInput.setText(note.title)
                        contentInput.setText(note.content)
                    }, { error -> Logger.e(error.message!!) })
            }
        } else {
            titleInput.setText(noteTitle)
            contentInput.setText(noteContent)
        }
    }

    private fun editNote() {
        val title = titleInput.text.toString()
        val content = contentInput.text.toString()
        val edited = notesViewModel.editNote(noteId!!, title, content)
        if (edited) {
            Toast.makeText(activity, "Note edited successfully" , Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager!!.popBackStack()
        } else {
            Toast.makeText(activity, "Something went wrong while editing the note" , Toast.LENGTH_SHORT).show()
        }

    }

    private val titleWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            titleInputLayout.error = getString(R.string.required)
            titleInputLayout.isErrorEnabled = titleInput.text.isNullOrBlank()
            val nonBlank = !(titleInput.text.isNullOrBlank()) && !(contentInput.text.isNullOrBlank())
            editNoteButton.isEnabled = nonBlank
        }
    }

    private val contentWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            contentInputLayout.error = getString(R.string.required)
            contentInputLayout.isErrorEnabled = contentInput.text.isNullOrBlank()
            val nonBlank = !(titleInput.text.isNullOrBlank()) && !(contentInput.text.isNullOrBlank())
            editNoteButton.isEnabled = nonBlank
        }
    }
}