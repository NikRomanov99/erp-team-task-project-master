package ru.rsu.task.app.erpteamtaskproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rsu.task.app.erpteamtaskproject.model.dto.TaskDto;
import ru.rsu.task.app.erpteamtaskproject.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping({"/task"})
    public List<TaskDto> getAll() {
        return service.getAllTasks();
    }

    @GetMapping({"/task/{taskId}"})
    public TaskDto getById(@PathVariable(value = "taskId") Long id) {
        return service.getTaskById(id);
    }

    @PostMapping({"/task"})
    public Long add(@RequestBody TaskDto employee) {
        return service.addTask(employee);
    }

    @PutMapping({"/task/{taskId}"})
    public Long update(@PathVariable(value = "taskId") Long id, @RequestBody TaskDto employee) {
        return service.updateTask(employee, id);
    }

    @DeleteMapping({"/task/{taskId}"})
    public Boolean update(@PathVariable(value = "taskId") Long id) {
        return service.deleteTaskById(id);
    }
}
