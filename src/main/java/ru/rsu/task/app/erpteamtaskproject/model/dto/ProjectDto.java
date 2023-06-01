package ru.rsu.task.app.erpteamtaskproject.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
public class ProjectDto {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime createDateTime;

    private LocalDateTime updateDateTime;

    private List<TaskDto> projectTasks;

    private ProjectStatusDto projectStatus;

    private EmployeeDto mainEmployee;

    private TeamDto team;
}
