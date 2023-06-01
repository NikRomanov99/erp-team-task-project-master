package ru.rsu.task.app.erpteamtaskproject.util;

import ru.rsu.task.app.erpteamtaskproject.model.dto.*;
import ru.rsu.task.app.erpteamtaskproject.model.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapperHelper {
    public static PositionDto mapToDto(PositionEntity entity) {
        if (Objects.nonNull(entity)) {
            PositionDto positionDto = new PositionDto();
            positionDto.setId(entity.getId());
            positionDto.setName(entity.getName());
            positionDto.setDescription(entity.getDescription());
            return positionDto;
        }
        return null;
    }

    public static ProjectStatusDto mapToDto(ProjectStatusEntity entity) {
        if (Objects.nonNull(entity)) {
            ProjectStatusDto projectStatusDto = new ProjectStatusDto();
            projectStatusDto.setId(entity.getId());
            projectStatusDto.setName(entity.getName());

            return projectStatusDto;
        }
        return null;
    }

    public static TaskStatusDto mapToDto(TaskStatusEntity entity) {
        if (Objects.nonNull(entity)) {
            TaskStatusDto taskStatusDto = new TaskStatusDto();
            taskStatusDto.setId(entity.getId());
            taskStatusDto.setName(entity.getName());

            return taskStatusDto;
        }
        return null;
    }

    public static EmployeeDto mapToDto(EmployeeEntity entity) {
        if (Objects.nonNull(entity)) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(entity.getId());
            employeeDto.setFullName(entity.getFullName());
            employeeDto.setEmail(entity.getEmail());
            employeeDto.setPosition(mapToDto(entity.getPosition()));
            if (Objects.nonNull(entity.getTeam())) {
                TeamDto teamDto = new TeamDto();
                teamDto.setId(entity.getTeam().getId());
                teamDto.setName(entity.getTeam().getName());
                employeeDto.setTeam(teamDto);
            }

            return employeeDto;
        }
        return null;
    }

    public static TeamDto mapToDto(TeamEntity entity) {
        if (Objects.nonNull(entity)) {
            TeamDto teamDto = new TeamDto();
            teamDto.setId(entity.getId());
            teamDto.setName(entity.getName());
            teamDto.setTeamLead(mapToDto(entity.getTeamLead()));
            if (!entity.getTeamProjects().isEmpty()) {
                List<ProjectDto> projectDtoList = new ArrayList<>();
                for (ProjectEntity projectEntity : entity.getTeamProjects()) {
                    ProjectDto projectDto = new ProjectDto();
                    projectDto.setId(projectEntity.getId());
                    projectDto.setName(projectEntity.getName());
                    projectDto.setCreateDateTime(projectEntity.getCreateDateTime());
                    projectDto.setUpdateDateTime(projectEntity.getUpdateDateTime());
                    projectDto.setProjectStatus(mapToDto(projectEntity.getProjectStatus()));
                    projectDto.setMainEmployee(mapToDto(projectEntity.getMainEmployee()));
                    projectDtoList.add(projectDto);
                }
                teamDto.setProjects(projectDtoList);
            } else {
                teamDto.setProjects(new ArrayList<>());
            }

            if (!entity.getTeamEmployee().isEmpty()) {
                var employeeDtoList = entity.getTeamEmployee().stream()
                        .map(MapperHelper::mapToDto)
                        .toList();
                teamDto.setTeamEmployees(employeeDtoList);
            } else {
                teamDto.setTeamEmployees(new ArrayList<>());
            }
            return teamDto;
        }
        return null;
    }

    public static ProjectDto mapToDto(ProjectEntity entity) {
        if (Objects.nonNull(entity)) {
            ProjectDto projectDto = new ProjectDto();
            projectDto.setId(entity.getId());
            projectDto.setName(entity.getName());
            projectDto.setDescription(entity.getDescription());
            projectDto.setCreateDateTime(entity.getCreateDateTime());
            projectDto.setUpdateDateTime(entity.getUpdateDateTime());
            projectDto.setProjectStatus(mapToDto(entity.getProjectStatus()));
            projectDto.setMainEmployee(mapToDto(entity.getMainEmployee()));
            if (Objects.nonNull(entity.getTeam())) {
                TeamDto teamDto = new TeamDto();
                teamDto.setId(entity.getTeam().getId());
                teamDto.setName(entity.getTeam().getName());
                projectDto.setTeam(teamDto);
            }
            if (!entity.getProjectTasks().isEmpty()) {
                List<TaskDto> taskDtoList = new ArrayList<>();
                for (var taskEntity : entity.getProjectTasks()) {
                    TaskDto taskDto = new TaskDto();
                    taskDto.setId(taskEntity.getId());
                    taskDto.setName(taskEntity.getName());
                    taskDto.setDescription(taskEntity.getDescription());
                    taskDto.setCreateDateTime(taskEntity.getCreateDateTime());
                    taskDto.setUpdateDateTime(taskEntity.getUpdateDateTime());
                    taskDto.setDeadlineDateTime(taskEntity.getDeadlineDateTime());
                    taskDto.setTaskStatus(mapToDto(taskEntity.getTaskStatus()));
                    taskDto.setEmployee(mapToDto(taskEntity.getEmployee()));
                    taskDtoList.add(taskDto);
                }
                projectDto.setProjectTasks(taskDtoList);
            } else {
                projectDto.setProjectTasks(new ArrayList<>());
            }
            return projectDto;
        }
        return null;
    }

    public static TaskDto mapToDto(TaskEntity entity) {
        if (Objects.nonNull(entity)) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(entity.getId());
            taskDto.setName(entity.getName());
            taskDto.setDescription(entity.getDescription());
            taskDto.setCreateDateTime(entity.getCreateDateTime());
            taskDto.setUpdateDateTime(entity.getUpdateDateTime());
            taskDto.setDeadlineDateTime(entity.getDeadlineDateTime());
            taskDto.setTaskStatus(mapToDto(entity.getTaskStatus()));
            taskDto.setEmployee(mapToDto(entity.getEmployee()));
            taskDto.setProject(mapToDto(entity.getProject()));
            return taskDto;
        }
        return null;
    }

    public static EmployeeEntity mapToEntity(EmployeeDto dto) {
        if (Objects.nonNull(dto)) {
            EmployeeEntity entity = new EmployeeEntity();
            entity.setFullName(dto.getFullName());
            entity.setEmail(dto.getEmail());

            if (Objects.nonNull(dto.getPosition()) && (dto.getPosition().getId() > 0)) {
                var positionEntity = new PositionEntity();
                positionEntity.setId(dto.getPosition().getId());
                entity.setPosition(positionEntity);
            }

            if (Objects.nonNull(dto.getTeam()) && (dto.getTeam().getId() > 0)) {
                var teamEntity = new TeamEntity();
                teamEntity.setId(dto.getTeam().getId());
                entity.setTeam(teamEntity);
            }
            return entity;
        }
        return null;
    }

    public static TeamEntity mapToEntity(TeamDto dto) {
        if (Objects.nonNull(dto)) {
            TeamEntity entity = new TeamEntity();
            entity.setName(dto.getName());
            if (Objects.nonNull(dto.getTeamLead()) && dto.getTeamLead().getId() > 0) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(dto.getTeamLead().getId());
                entity.setTeamLead(employeeEntity);
            }
            return entity;
        }
        return null;
    }

    public static ProjectEntity mapToEntity(ProjectDto dto) {
        if (Objects.nonNull(dto)) {
            ProjectEntity entity = new ProjectEntity();
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setCreateDateTime(dto.getCreateDateTime());
            entity.setUpdateDateTime(dto.getUpdateDateTime());
            if (Objects.nonNull(dto.getMainEmployee()) && dto.getMainEmployee().getId() > 0) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(dto.getMainEmployee().getId());
                entity.setMainEmployee(employeeEntity);
            }
            if (Objects.nonNull(dto.getTeam()) && dto.getTeam().getId() > 0) {
                TeamEntity teamEntity = new TeamEntity();
                teamEntity.setId(dto.getTeam().getId());
                entity.setTeam(teamEntity);
            }
            if (Objects.nonNull(dto.getProjectStatus()) && dto.getProjectStatus().getId() > 0) {
                ProjectStatusEntity statusEntity = new ProjectStatusEntity();
                statusEntity.setId(dto.getProjectStatus().getId());
                entity.setProjectStatus(statusEntity);
            }
            return entity;
        }
        return null;
    }

    public static TaskEntity mapToEntity(TaskDto dto) {
        if (Objects.nonNull(dto)) {
            TaskEntity entity = new TaskEntity();
            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());
            entity.setCreateDateTime(entity.getCreateDateTime());
            entity.setUpdateDateTime(entity.getUpdateDateTime());
            entity.setDeadlineDateTime(entity.getDeadlineDateTime());
            if (Objects.nonNull(dto.getTaskStatus()) && dto.getTaskStatus().getId() > 0) {
                TaskStatusEntity taskStatusEntity = new TaskStatusEntity();
                taskStatusEntity.setId(dto.getTaskStatus().getId());
                entity.setTaskStatus(taskStatusEntity);
            }
            if (Objects.nonNull(dto.getEmployee()) && dto.getEmployee().getId() > 0) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(dto.getEmployee().getId());
                entity.setEmployee(employeeEntity);
            }
            if (Objects.nonNull(dto.getProject()) && dto.getProject().getId() > 0) {
                ProjectEntity projectEntity = new ProjectEntity();
                projectEntity.setId(dto.getProject().getId());
                entity.setProject(projectEntity);
            }
            return entity;
        }
        return null;
    }
}
