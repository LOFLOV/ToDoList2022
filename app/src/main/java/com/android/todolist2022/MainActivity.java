package com.android.todolist2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.todolist2022.ui.list.NotesListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openNoteListScreen();
        onNavigationItemSelected();

    }

    private void openNoteListScreen() {
        NotesListFragment notesListFragment = new NotesListFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, notesListFragment)
                .commit();
    }

    private void onNavigationItemSelected() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_one:

                        openNoteListScreen();

                        return true;

                    case R.id.action_two:

                        Toast.makeText(getApplicationContext(), "calendar", Toast.LENGTH_SHORT).show();

                        return true;
                }
                return false;
            }
        });
    }
}