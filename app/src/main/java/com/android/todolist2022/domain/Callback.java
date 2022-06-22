package com.android.todolist2022.domain;

public interface Callback<T> {

    void  onSuccess(T result);

    void onError(Throwable error);
}
