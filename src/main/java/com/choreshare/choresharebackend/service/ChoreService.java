package com.choreshare.choresharebackend.service;

import com.choreshare.choresharebackend.model.Chore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ChoreService {

    @Autowired
    ChoreRepository choreRepository;

    public List<Chore> getAllChores() {return choreRepository.findAll();}

    public Chore updateChoreStatus(Long id, Chore chore) {
        Optional<Chore> ChoreOptional = choreRepository.findById(id);
        if(!ChoreOptional.isPresent()){
            throw new EntityNotFoundException(chore.getId().toString());
        }
        Chore updatedChore = ChoreOptional.get();
        updatedChore.setDone(!updatedChore.isDone());
        return choreRepository.save(updatedChore);
    }
}
