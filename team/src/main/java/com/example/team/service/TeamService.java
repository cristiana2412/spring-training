package com.example.team.service;

import com.example.team.dto.FullPersonDTO;
import com.example.team.dto.FullTeamDTO;
import com.example.team.dto.TeamDTO;
import com.example.team.entity.Team;
import com.example.team.repository.PersonRepository;
import com.example.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class TeamService {

    private final PersonRepository personRepository;
    private final TeamRepository teamRepository;

    public Long add(TeamDTO teamDTO){
        Team team = new Team();
        team.setName(teamDTO.getName());
        return teamRepository.save(team).getId();
    }

    public List<FullTeamDTO> findAll() {
        return teamRepository.findAll().stream().map(t-> {
            FullTeamDTO dto = new FullTeamDTO();
            dto.setId(t.getId());
            dto.setName(t.getName());
            return dto;
        }).collect(Collectors.toList());
    }

    public void update(Long id, TeamDTO dto){
        Team team = teamRepository.getOne(id);
        team.setName(dto.getName());
        teamRepository.save(team);
    }

    public TeamDTO getOne(Long id){
        Team team = teamRepository.findById(id).orElse(new Team());
        TeamDTO dto = new TeamDTO();
        dto.setName(team.getName());
        return dto;
    }

    public void delete(Long id){
        teamRepository.deleteById(id);
    }

    public List<FullPersonDTO> findPersons(Long id){
        return personRepository.findByTeamId(id).stream().map(p-> {
            FullPersonDTO dto = new FullPersonDTO();
            dto.setId(p.getId());
            dto.setFirstName(p.getFirstName());
            dto.setLastName(p.getLastName());
            dto.setTeamName(p.getTeam().getName());
            return dto;
        }).collect(Collectors.toList());
    }

}
