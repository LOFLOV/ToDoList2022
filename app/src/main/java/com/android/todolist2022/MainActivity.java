package com.android.todolist2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.todolist2022.ui.NotesListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openNoteListScreen();

    }

    private void openNoteListScreen() {
        NotesListFragment notesListFragment = new NotesListFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, notesListFragment)
                .commit();
    }


}