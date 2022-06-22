package com.android.todolist2022.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.todolist2022.R;
import com.android.todolist2022.domain.Note;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private List<Note> items;
    public NoteClickListener clickListener;

    public NoteListAdapter(List<Note> items, NoteClickListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }

    @NonNull @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = items.get(position);
        holder.bind(note);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onNoteClicked(note);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private TextView date;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title_note);
            this.description = itemView.findViewById(R.id.name_description);
            this.date = itemView.findViewById(R.id.name_date_create);
        }

        public void bind(Note note) {
            title.setText(note.getTitle());
            description.setText(note.getMessage());
            date.setText(note.getCreatedAt().toString());
        }
    }

    public interface NoteClickListener {
        void onNoteClicked(Note note);
    }
}
