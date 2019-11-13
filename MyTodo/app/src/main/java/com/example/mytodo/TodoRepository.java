package com.example.mytodo;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.mytodo.database.AppDatabase;
import com.example.mytodo.database.Todo;
import com.example.mytodo.database.TodoDao;

import java.util.List;

public class TodoRepository {

    private TodoDao todoDao;
    private LiveData<List<Todo>> mAllTodos;

    TodoRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        todoDao = db.todoDao();
        mAllTodos = todoDao.getAllTodos();
    }

    LiveData<List<Todo>> getAllWords() {
        return mAllTodos;
    }

    public void insert (final Todo todo) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.insertTodo(todo);
            }
        });
    }

    public void delete(final Todo todo)  {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.deleteTodo(todo);
            }
        });
    }

    public void update(final Todo todo)  {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.update(todo);
            }
        });
    }

}
