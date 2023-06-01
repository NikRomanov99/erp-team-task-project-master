package ru.rsu.task.app.erpteamtaskproject.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rsu.task.app.erpteamtaskproject.model.dto.EmployeeDto;
import ru.rsu.task.app.erpteamtaskproject.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping({"/employee"})
    public List<EmployeeDto> getAll() {
        return service.getAllEmployee();
    }

    @GetMapping({"/employee/{employeeId}"})
    public EmployeeDto getById(@PathVariable(value = "employeeId") Long id) {
        return service.getEmployeeById(id);
    }

    @PostMapping({"/employee"})
    public Long add(@RequestBody EmployeeDto employee) {
        return service.addEmployee(employee);
    }

    @PutMapping({"/employee/{employeeId}"})
    public Long update(@PathVariable(value = "employeeId") Long id, @RequestBody EmployeeDto employee) {
        return service.updateEmployee(employee, id);
    }

    @DeleteMapping({"/employee/{employeeId}"})
    public Boolean update(@PathVariable(value = "employeeId") Long id) {
        return service.deleteEmployeeById(id);
    }
}
