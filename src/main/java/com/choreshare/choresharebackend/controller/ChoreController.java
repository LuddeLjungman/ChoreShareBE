package com.choreshare.choresharebackend.controller;

import com.choreshare.choresharebackend.model.Chore;
import com.choreshare.choresharebackend.model.Todo;
import com.choreshare.choresharebackend.service.ChoreService;
import com.choreshare.choresharebackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/chore", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChoreController {

    @Autowired
    ChoreService choreService;

    @GetMapping(path="/all")
    public List<Chore> getAll(){
        return choreService.getAllChores();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Chore> updateChoreById(@PathVariable Long id, @RequestBody Chore newChore){
        Chore chore = choreService.updateChoreStatus(id, newChore);
        return new ResponseEntity<>(chore, HttpStatus.CREATED);
    }


}
