package ru.rsu.task.app.erpteamtaskproject.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
@EqualsAndHashCode
public class ProjectEntity {
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

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToMany(targetEntity = TaskEntity.class, mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskEntity> projectTasks;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = ProjectStatusEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_project_status_id")
    private ProjectStatusEntity projectStatus;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = EmployeeEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_main_employee_id", nullable = false)
    private EmployeeEntity mainEmployee;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = TeamEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_team_id")
    private TeamEntity team;
}
