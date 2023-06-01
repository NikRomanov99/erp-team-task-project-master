package ru.rsu.task.app.erpteamtaskproject.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "team")
@EqualsAndHashCode
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = EmployeeEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_teamlead_id", referencedColumnName = "id")
    private EmployeeEntity teamLead;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToMany(targetEntity = ProjectEntity.class, mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectEntity> teamProjects;

    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    @OneToMany(targetEntity = EmployeeEntity.class, mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmployeeEntity> teamEmployee;
}
