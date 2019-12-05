package com.example.team;

import com.example.team.repository.PersonRepository;
import com.example.team.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamApplicationTests {
	@Autowired
	TeamRepository teamRepository;
	@Autowired
	PersonRepository personRepository;

	@Test
	void contextLoads() {


	}

	@Test
	void shallFindTeams(){
		assertTrue( teamRepository.findAll().size() > 0);
	}

}
