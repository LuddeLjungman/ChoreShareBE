package com.choreshare.choresharebackend.controller;

import com.choreshare.choresharebackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/chore", produces = MediaType.APPLICATION_JSON_VALUE)
public class ChoreController {

    @Autowired
    TodoService todoService;


}
