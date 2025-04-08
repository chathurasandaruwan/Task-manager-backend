package lk.ijse.Task_manager_backend.dao;

import lk.ijse.Task_manager_backend.entity.impl.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TaskDAO extends JpaRepository<TaskEntity, String> {

}

