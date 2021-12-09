package com.android.todolist2022.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    public String title;
    public String description;
    public String date;

    public Note() {
    }

    public Note(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }


    protected Note(Parcel in) {
        title = in.readString();
        description = in.readString();
        date = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(date);
    }
}
