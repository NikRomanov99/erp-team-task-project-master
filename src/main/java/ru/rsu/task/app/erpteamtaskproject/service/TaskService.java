package ru.rsu.task.app.erpteamtaskproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsu.task.app.erpteamtaskproject.model.dto.TaskDto;
import ru.rsu.task.app.erpteamtaskproject.repository.TaskRepository;
import ru.rsu.task.app.erpteamtaskproject.util.MapperHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToDto;
import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToEntity;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    public List<TaskDto> getAllTasks() {
        var listOfEntities = repository.findAll();
        if (!listOfEntities.isEmpty()) {
            return listOfEntities.stream()
                    .map(MapperHelper::mapToDto)
                    .toList();
        }
        return Collections.emptyList();
    }

    public TaskDto getTaskById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapToDto(entity.get());
        }
        return new TaskDto();
    }

    public Long addTask(TaskDto teamDto) {
        if (Objects.nonNull(teamDto)) {
            var entity = repository.save(mapToEntity(teamDto));
            return entity.getId();
        }
        return null;
    }

    public Long updateTask(TaskDto teamDto, Long id) {
        if (Objects.nonNull(teamDto)) {
            var entity = mapToEntity(teamDto);
            if (Objects.nonNull(entity)) {
                entity.setId(id);
                var result = repository.save(entity);
                return result.getId();
            }
        }
        return null;
    }

    public boolean deleteTaskById(Long id) {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
