package ru.rsu.task.app.erpteamtaskproject.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Getter
@Setter
@Entity
@Table(name = "employee")
@EqualsAndHashCode
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email_address")
    private String email;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = PositionEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_position_id", referencedColumnName = "id")
    private PositionEntity position;

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = TeamEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_team_id", referencedColumnName = "id")
    private TeamEntity team;
}
