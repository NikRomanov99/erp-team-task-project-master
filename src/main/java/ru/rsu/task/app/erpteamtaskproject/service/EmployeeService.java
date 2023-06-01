package ru.rsu.task.app.erpteamtaskproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rsu.task.app.erpteamtaskproject.model.dto.EmployeeDto;
import ru.rsu.task.app.erpteamtaskproject.repository.EmployeeRepository;
import ru.rsu.task.app.erpteamtaskproject.util.MapperHelper;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToDto;
import static ru.rsu.task.app.erpteamtaskproject.util.MapperHelper.mapToEntity;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<EmployeeDto> getAllEmployee() {
        var listOfEntity = repository.findAll();
        if (!listOfEntity.isEmpty()) {
            return listOfEntity.stream()
                    .map(MapperHelper::mapToDto)
                    .toList();
        }
        return Collections.emptyList();
    }

    public EmployeeDto getEmployeeById(Long id) {
        var entity = repository.findById(id);
        if (entity.isPresent()) {
            return mapToDto(entity.get());
        }
        return new EmployeeDto();
    }

    public Long addEmployee(EmployeeDto employeeDto) {
        if (Objects.nonNull(employeeDto)) {
            var entity = repository.save(mapToEntity(employeeDto));
            return entity.getId();
        }
        return null;
    }

    public Long updateEmployee(EmployeeDto employeeDto, Long id) {
        if (Objects.nonNull(employeeDto)) {
            var entity = mapToEntity(employeeDto);
            if (Objects.nonNull(entity)) {
                entity.setId(id);
                var result = repository.save(entity);
                return result.getId();
            }
        }
        return null;
    }

    public boolean deleteEmployeeById(Long id) {
        if (Objects.nonNull(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
