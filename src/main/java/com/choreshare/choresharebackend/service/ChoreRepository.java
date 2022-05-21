package com.choreshare.choresharebackend.service;

import com.choreshare.choresharebackend.model.Chore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoreRepository extends JpaRepository<Chore, Long> {
}
