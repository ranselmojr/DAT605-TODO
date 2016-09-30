package edu.nu.dat605.controller;

import edu.nu.dat605.entity.Todo;
import edu.nu.dat605.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZS13478 on 9/29/2016.
 */
@RestController
public class TodoController {

    @Autowired
    TodoRepo todoRepo;

    @RequestMapping(path = "/todo", method = RequestMethod.GET)
    public List<Todo> getTodos(){

        List<Todo> todos = todoRepo.findAll();

        return todos;
    }

    @RequestMapping(path = "/todo/{id}", method = RequestMethod.GET)
    public Todo getTodo(@PathVariable(name = "id", required = true) Integer id){

        Todo todo = todoRepo.findOne(id);

        return todo;
    }


    @RequestMapping(path = "/todo", method = RequestMethod.POST)
    public Todo createTodo(@RequestBody Todo _todo){

        Todo todo = todoRepo.save(_todo);

        return todo;
    }

    @RequestMapping(path = "/todo/{id}", method = RequestMethod.PUT)
    public Todo updateTodo(@RequestBody Todo _todo){

        Todo todo = todoRepo.save(_todo);

        return todo;
    }

    @RequestMapping(path = "/todo/{id}", method = RequestMethod.DELETE)
    public Boolean deleteTodo(@PathVariable(name = "id") Integer id){

        todoRepo.delete(id);

        return true;
    }

}
