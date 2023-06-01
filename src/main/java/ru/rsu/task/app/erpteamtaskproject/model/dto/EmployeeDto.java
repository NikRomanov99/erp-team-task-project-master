package ru.rsu.task.app.erpteamtaskproject.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class EmployeeDto {
    private Long id;

    private String fullName;

    private String email;

    private PositionDto position;

    private TeamDto team;
}
