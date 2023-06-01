package ru.rsu.task.app.erpteamtaskproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rsu.task.app.erpteamtaskproject.model.dto.ProjectDto;
import ru.rsu.task.app.erpteamtaskproject.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;
    
    @GetMapping({"/project"})
    public List<ProjectDto> getAll() {
        return service.getAllProjects();
    }

    @GetMapping({"/project/{projectId}"})
    public ProjectDto getById(@PathVariable(value = "projectId") Long id) {
        return service.getProjectById(id);
    }

    @PostMapping({"/project"})
    public Long add(@RequestBody ProjectDto employee) {
        return service.addProject(employee);
    }

    @PutMapping({"/project/{projectId}"})
    public Long update(@PathVariable(value = "projectId") Long id, @RequestBody ProjectDto employee) {
        return service.updateProject(employee, id);
    }

    @DeleteMapping({"/project/{projectId}"})
    public Boolean update(@PathVariable(value = "projectId") Long id) {
        return service.deleteProjectById(id);
    }
}
