package com.example.team.repository;

import com.example.team.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByTeamId(Long id);

    @Query(value = "update Person p set p.team = null where p.team.id = ?1", nativeQuery = true)
    @Modifying
    public void removePersonsFromTeam(Long teamId);
}
