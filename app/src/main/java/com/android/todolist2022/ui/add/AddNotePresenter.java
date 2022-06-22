package com.android.todolist2022.ui.add;

import com.android.todolist2022.domain.Callback;
import com.android.todolist2022.domain.Note;
import com.android.todolist2022.domain.NotesRepository;

public class AddNotePresenter {

    private AddNoteView view;
    private NotesRepository repository;

    public AddNotePresenter(AddNoteView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public AddNotePresenter() {

    }

    public void saveNote(String title, String message) {
        view.showProgress();

        repository.save(title, message, new Callback<Note>() {
            @Override
            public void onSuccess(Note result) {
                view.hideProgress();
                view.noteSaved(result);
            }

            @Override
            public void onError(Throwable error) {
                view.hideProgress();
            }
        });
    }
}
