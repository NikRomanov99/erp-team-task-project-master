package ru.rsu.task.app.erpteamtaskproject.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@RequiredArgsConstructor
public class TaskDto {
    private Long id;

    private String name;

    private String description;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    private LocalDateTime deadlineDateTime;

    private TaskStatusDto taskStatus;

    private EmployeeDto employee;

    private ProjectDto project;
}
