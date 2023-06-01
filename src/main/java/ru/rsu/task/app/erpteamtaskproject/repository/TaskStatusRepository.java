package ru.rsu.task.app.erpteamtaskproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rsu.task.app.erpteamtaskproject.model.entity.TaskStatusEntity;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatusEntity, Long> {
}
