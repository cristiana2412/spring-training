package com.example.team.repository;

import com.example.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface TeamRepository extends JpaRepository<Team, Long> {

}
