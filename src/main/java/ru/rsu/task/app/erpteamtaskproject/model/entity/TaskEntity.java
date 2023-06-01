package ru.rsu.task.app.erpteamtaskproject.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "task")
@EqualsAndHashCode
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "create_dt")
    private LocalDateTime createDateTime;

    @Column(name = "update_dt")
    private LocalDateTime updateDateTime;

    @Column(name = "deadline_dt")
    private LocalDateTime deadlineDateTime;

    @ManyToOne(targetEntity = TaskStatusEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_task_status_id")
    private TaskStatusEntity taskStatus;

    @ManyToOne(targetEntity = EmployeeEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_employee_id")
    private EmployeeEntity employee;

    @ManyToOne(targetEntity = ProjectEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_project_id")
    private ProjectEntity project;

}
