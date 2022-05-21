package com.choreshare.choresharebackend.controller;

import com.choreshare.choresharebackend.model.Todo;
import com.choreshare.choresharebackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(path="/all")
    public List<Todo> getAll(){
        return todoService.getAllTodos();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        try{
            Todo todo = todoService.findTodoById(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (NoSuchElementException error){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(path = "/create")
    public ResponseEntity<Todo> createNewTodo(@RequestBody Todo newTodo){
        Todo todo = todoService.createTodo(newTodo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable Long id, @RequestBody Todo newTodo) {
        Todo todo = todoService.updateTodo(id, newTodo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @PutMapping(path = "/completed/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Todo> updateTodoCompletedById(@PathVariable Long id, @RequestBody Todo newTodo) {
        Todo todo = todoService.updateTodoCompleteStatus(id, newTodo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Todo> deleteTodoById(@PathVariable Long id) {
        Todo todo = todoService.deleteTodo(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping(path = "/all")
    public List<Todo> deleteAllCompletedTodos() {
        List<Todo> todos = todoService.deleteAllCompletedTodos();
        return todos;
    }
}
