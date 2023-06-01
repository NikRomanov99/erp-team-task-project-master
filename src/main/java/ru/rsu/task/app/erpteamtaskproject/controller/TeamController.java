package ru.rsu.task.app.erpteamtaskproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rsu.task.app.erpteamtaskproject.model.dto.TeamDto;
import ru.rsu.task.app.erpteamtaskproject.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService service;

    @GetMapping({"/team"})
    public List<TeamDto> getAll() {
        return service.getAllTeams();
    }

    @GetMapping({"/team/{teamId}"})
    public TeamDto getById(@PathVariable(value = "teamId") Long id) {
        return service.getTeamById(id);
    }

    @PostMapping({"/team"})
    public Long add(@RequestBody TeamDto employee) {
        return service.addTeam(employee);
    }

    @PutMapping({"/team/{teamId}"})
    public Long update(@PathVariable(value = "teamId") Long id, @RequestBody TeamDto employee) {
        return service.updateTeam(employee, id);
    }

    @DeleteMapping({"/team/{teamId}"})
    public Boolean update(@PathVariable(value = "teamId") Long id) {
        return service.deleteTeamById(id);
    }
}
