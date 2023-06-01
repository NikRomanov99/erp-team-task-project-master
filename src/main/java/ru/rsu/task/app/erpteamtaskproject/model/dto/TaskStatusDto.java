package ru.rsu.task.app.erpteamtaskproject.model.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class TaskStatusDto {
    private Long id;

    private String name;
}
