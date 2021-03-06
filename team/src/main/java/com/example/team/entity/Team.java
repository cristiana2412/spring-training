package com.example.team.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
