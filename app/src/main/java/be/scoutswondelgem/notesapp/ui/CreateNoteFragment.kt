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
import be.scoutswondelgem.notesapp.databinding.FragmentCreateNoteBinding
import be.scoutswondelgem.notesapp.viewmodels.NotesViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_create_note.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class CreateNoteFragment: Fragment() {
    //Voor creatie CreateNoteFragment
    companion object {
        @JvmStatic
        fun newInstance() = CreateNoteFragment()
    }

    //UI elementen:
    private lateinit var addNoteButton: Button
    private lateinit var titleInputLayout: TextInputLayout
    private lateinit var titleInput: TextInputEditText
    private lateinit var contentInputLayout: TextInputLayout
    private lateinit var contentInput: TextInputEditText

    //Injecteren:
    private val notesViewModel by viewModel<NotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCreateNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_create_note, container, false)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.notesViewModel = notesViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNoteButton = view.button_addNote
        titleInputLayout = view.inputLayout_title
        titleInput = view.input_title
        contentInputLayout = view.inputLayout_content
        contentInput = view.input_content
        titleInput.addTextChangedListener(titleWatcher)
        contentInput.addTextChangedListener(contentWatcher)
        addNoteButton.setOnClickListener {
            createNote()
        }
    }

    private fun createNote() {
        val title = titleInput.text.toString()
        val content = contentInput.text.toString()
        val created = notesViewModel.createNote(title, content)
        if (created) {
            Toast.makeText(activity, "Note created successfully" , Toast.LENGTH_SHORT).show()
            activity?.supportFragmentManager!!.popBackStack()
        } else {
            Toast.makeText(activity, "Something went wrong while creating the note" , Toast.LENGTH_SHORT).show()
        }

    }

    private val titleWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            titleInputLayout.error = getString(R.string.required)
            titleInputLayout.isErrorEnabled = titleInput.text.isNullOrBlank()
            val nonBlank = !(titleInput.text.isNullOrBlank()) && !(contentInput.text.isNullOrBlank())
            addNoteButton.isEnabled = nonBlank
        }
    }

    private val contentWatcher = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            contentInputLayout.error = getString(R.string.required)
            contentInputLayout.isErrorEnabled = contentInput.text.isNullOrBlank()
            val nonBlank = !(titleInput.text.isNullOrBlank()) && !(contentInput.text.isNullOrBlank())
            addNoteButton.isEnabled = nonBlank
        }
    }
}