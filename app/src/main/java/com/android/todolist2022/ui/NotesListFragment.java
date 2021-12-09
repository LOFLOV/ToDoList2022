package com.android.todolist2022.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.todolist2022.R;
import com.android.todolist2022.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesListFragment extends Fragment implements NoteListAdapter.NoteClickListener {

    public static final String KEY_NOTE = "KEY_NOTE";

    private RecyclerView recyclerView;
    private NoteListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<Note> items = generateNotes();
        adapter = new NoteListAdapter(items,this);
        recyclerView.setAdapter(adapter);

    }

    private List<Note> generateNotes() {
        List<Note> list = new ArrayList<>();
        Note note1 = new Note("Note1", "pass","12.02.2020");
        Note note2 = new Note("Note2", "adres","01.12.2010");
        Note note3 = new Note("Note3", "e-mail","22.02.2022");
        list.add(note1);
        list.add(note2);
        list.add(note3);
        return list;
    }

    @Override
    public void onNoteClicked(Note note) {
        openInternalNoteScreen(note);
    }

    private void openInternalNoteScreen(Note note) {
        InternalNoteFragment internalNoteFragment = new InternalNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_NOTE, note);
        internalNoteFragment.setArguments(args);

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, internalNoteFragment)
                .addToBackStack("")
                .commit();
    }
}
