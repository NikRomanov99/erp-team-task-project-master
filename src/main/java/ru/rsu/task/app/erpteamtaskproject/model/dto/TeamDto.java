package ru.rsu.task.app.erpteamtaskproject.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
public class TeamDto {
    private Long id;

    private String name;

    private EmployeeDto teamLead;

    private List<EmployeeDto> teamEmployees;

    private List<ProjectDto> projects;
}
