package com.choreshare.choresharebackend.model;

import lombok.*;

import javax.persistence.*;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Long id;

    @Column(name="body")
    private String body;

    @Column(name="completed")
    private boolean completed;
}
