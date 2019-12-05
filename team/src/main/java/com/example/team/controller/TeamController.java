package com.example.team.controller;

import com.example.team.dto.FullPersonDTO;
import com.example.team.dto.FullTeamDTO;
import com.example.team.dto.TeamDTO;
import com.example.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public TeamDTO one(@PathVariable Long id) {
        return teamService.getOne(id);
    }

    @GetMapping("/{id}/person")
    public List<FullPersonDTO> findPersons(@PathVariable Long id) {
        return teamService.findPersons(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }
}
