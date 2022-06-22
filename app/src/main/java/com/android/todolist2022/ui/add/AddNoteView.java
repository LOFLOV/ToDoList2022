package com.android.todolist2022.ui.add;

import com.android.todolist2022.domain.Note;

public interface AddNoteView {

    void showProgress();

    void hideProgress();

    void noteSaved(Note note);

}
