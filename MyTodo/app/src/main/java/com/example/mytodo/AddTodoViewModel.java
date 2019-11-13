package com.example.mytodo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mytodo.database.AppDatabase;
import com.example.mytodo.database.Todo;

public class AddTodoViewModel extends ViewModel {

    private LiveData<Todo> todo;

    public AddTodoViewModel(AppDatabase database, int todoId){
        todo = database.todoDao().loadTodoById(todoId);
    }

    public LiveData<Todo> getTodo() {
        return todo;
    }


}
