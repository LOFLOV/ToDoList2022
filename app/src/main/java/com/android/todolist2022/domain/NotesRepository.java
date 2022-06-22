package com.android.todolist2022.domain;

import java.util.List;

public interface NotesRepository {

    void getAll(Callback<List<Note>> callback);

    void save(String title, String message, Callback<Note> callback);
}
