package com.android.todolist2022.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.todolist2022.R;
import com.android.todolist2022.domain.InMemoryNotesRepository;
import com.android.todolist2022.domain.Note;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddNoteBottomSheetDialogFragment extends BottomSheetDialogFragment implements AddNoteView {

    public static final String TAG = "AddNoteBottomSheetDialogFragment";

    public static final String KEY = "AddNoteBottomSheetDialogFragment";
    public static final String ARG_NOTE = "ARG_NOTE";

    public static AddNoteBottomSheetDialogFragment newInstance() {
        AddNoteBottomSheetDialogFragment fragment = new AddNoteBottomSheetDialogFragment();

        return fragment;
    }

    private Button btnSave;
    private ProgressBar progressBar;

    private AddNotePresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new AddNotePresenter(this, InMemoryNotesRepository.INSTANCE);
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_not_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar = view.findViewById(R.id.progress_bar);
        btnSave = view.findViewById(R.id.btn_save);

        EditText title = view.findViewById(R.id.title_add);
        EditText message = view.findViewById(R.id.message_add);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.saveNote(title.getText().toString(), message.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        btnSave.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        btnSave.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void noteSaved(Note note) {

        Bundle result = new Bundle();
        result.putParcelable(ARG_NOTE, result);
        getParentFragmentManager()
                .setFragmentResult(KEY, result);
    }
}
