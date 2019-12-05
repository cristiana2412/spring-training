package com.example.team.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Person {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Team team;
}
