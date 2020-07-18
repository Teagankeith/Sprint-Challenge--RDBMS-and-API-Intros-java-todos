package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Transactional
@Service(value ="todoService")
public class TodosServiceImpl implements TodosService {

    @Autowired
    TodoRepository todorepos;


    @Autowired
    UserService userService;


    @Override
    public void markComplete(long todoid) {

    }



    @Transactional
    @Override
    public Todos updateTodo(Todos todo, long id) {
        Todos updateTodo = getTodoById(id);

        if (todo.getDiscription() != null) {
            updateTodo.setDiscription(todo.getDiscription());

        }
        if (todo.getUser() != null) {
            updateTodo.setUser(userService.findUserById(todo.getUser().getUserid()));

        }

        if (todo.completedSwap) {
            updateTodo.setCompleted(todo.completedMethod());
        }

        return todorepos.save(updateTodo);
    }

    @Override
    public Todos getTodoById(long id) {
        return todorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo with " + id + " not found!"));
    }

    @Override
    public Todos save(Todos todo, long userid) {
        Todos nTodo = new Todos();



        nTodo.setDiscription(todo.getDiscription());
        nTodo.setUser(todo.getUser());

        return todorepos.save(nTodo);
    }


}
