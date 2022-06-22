package com.android.todolist2022.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.todolist2022.R;
import com.android.todolist2022.ui.add.AddNoteBottomSheetDialogFragment;
import com.android.todolist2022.domain.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class NotesListFragment extends Fragment implements NoteListAdapter.NoteClickListener {

    public static final String KEY_NOTE = "KEY_NOTE";

    private RecyclerView recyclerView;
    private NoteListAdapter adapter;

    @Nullable @Override
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

        view.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNoteBottomSheetDialogFragment.newInstance()
                        .show(getParentFragmentManager(), AddNoteBottomSheetDialogFragment.TAG);
            }
        });
        
    }

    private List<Note> generateNotes() {
        List<Note> list = new ArrayList<>();
        Note note1 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note2 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note3 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note4 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note5 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note6 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note7 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note8 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note9 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        Note note10 = new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date());
        list.add(note1);
        list.add(note2);
        list.add(note3);
        list.add(note4);
        list.add(note5);
        list.add(note6);
        list.add(note7);
        list.add(note8);
        list.add(note9);
        list.add(note10);
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
