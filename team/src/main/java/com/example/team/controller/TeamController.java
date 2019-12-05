package com.example.team.controller;

import com.example.team.dto.FullPersonDTO;
import com.example.team.dto.FullTeamDTO;
import com.example.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<FullTeamDTO> all() {
        return teamService.findAll();
    }

    @GetMapping("/{id}/person")
    public List<FullPersonDTO> findPersons(@PathVariable Long id) {
        return teamService.findPersons(id);
    }
}
