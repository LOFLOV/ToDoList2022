package com.android.todolist2022.domain;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class InMemoryNotesRepository implements NotesRepository {

    public static final NotesRepository INSTANCE = new InMemoryNotesRepository();

    private Executor executor = Executors.newSingleThreadExecutor();

    private ArrayList<Note> result = new ArrayList<>();

    private Handler handler = new Handler(Looper.getMainLooper());

    private InMemoryNotesRepository() {
        result.add(new Note(UUID.randomUUID().toString(),"title 1", "message 1", new Date()));
        result.add(new Note(UUID.randomUUID().toString(),"title 2", "message 2", new Date()));
        result.add(new Note(UUID.randomUUID().toString(),"title 3", "message 3", new Date()));
        result.add(new Note(UUID.randomUUID().toString(),"title 4", "message 4", new Date()));
        result.add(new Note(UUID.randomUUID().toString(),"title 5", "message 5", new Date()));
        result.add(new Note(UUID.randomUUID().toString(),"title 6", "message 6", new Date()));
    }

    @Override
    public void getAll(Callback<List<Note>> callback) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });
    }

    @Override
    public void save(String title, String message, Callback<Note> callback) {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Note note12 = new Note(UUID.randomUUID().toString(),"BIG TITLE", "message 11231313", new Date());
                        result.add(note12);
                        callback.onSuccess(note12);
                    }
                });
            }
        });
    }
}
