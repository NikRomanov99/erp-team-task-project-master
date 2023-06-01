package ru.rsu.task.app.erpteamtaskproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsu.task.app.erpteamtaskproject.model.dto.TeamDto;
import ru.rsu.task.app.erpteamtaskproject.repository.TeamRepository;
import ru.rsu.task.app.erpteamtaskproject.util.MapperHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToDto;
import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToEntity;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository repository;

    public List<TeamDto> getAllTeams() {
        var listOfEntities = repository.findAll();
        if (!listOfEntities.isEmpty()) {
            return listOfEntities.stream()
                    .map(MapperHelper::mapToDto)
                    .toList();
        }
        return Collections.emptyList();
    }

    public TeamDto getTeamById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapToDto(entity.get());
        }
        return new TeamDto();
    }

    public Long addTeam(TeamDto teamDto) {
        if (Objects.nonNull(teamDto)) {
            var entity = repository.save(mapToEntity(teamDto));
            return entity.getId();
        }
        return null;
    }

    public Long updateTeam(TeamDto teamDto, Long id) {
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

    public boolean deleteTeamById(Long id) {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
