package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

public interface TodosService
{
    void markComplete(long todoid);

    Todos updateTodo(Todos todo, long id);

    Todos getTodoById(long id);

    Todos save(Todos todo, long userid);
}
