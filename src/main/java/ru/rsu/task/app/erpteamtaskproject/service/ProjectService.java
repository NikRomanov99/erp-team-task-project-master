package ru.rsu.task.app.erpteamtaskproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsu.task.app.erpteamtaskproject.model.dto.ProjectDto;
import ru.rsu.task.app.erpteamtaskproject.repository.ProjectRepository;
import ru.rsu.task.app.erpteamtaskproject.util.MapperHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToDto;
import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToEntity;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;

    public List<ProjectDto> getAllProjects() {
        var listOfEntities = repository.findAll();
        if (!listOfEntities.isEmpty()) {
            return listOfEntities.stream()
                    .map(MapperHelper::mapToDto)
                    .toList();
        }
        return Collections.emptyList();
    }

    public ProjectDto getProjectById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapToDto(entity.get());
        }
        return new ProjectDto();
    }

    public Long addProject(ProjectDto projectDto) {
        if (Objects.nonNull(projectDto)) {
            var entity = repository.save(mapToEntity(projectDto));
            return entity.getId();
        }
        return null;
    }

    public Long updateProject(ProjectDto projectDto, Long id) {
        if (Objects.nonNull(projectDto)) {
            var entity = mapToEntity(projectDto);
            if (Objects.nonNull(entity)) {
                entity.setId(id);
                var result = repository.save(entity);
                return result.getId();
            }
        }
        return null;
    }

    public boolean deleteProjectById(Long id) {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
