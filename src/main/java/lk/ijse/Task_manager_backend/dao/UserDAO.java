package lk.ijse.Task_manager_backend.dao;


import lk.ijse.Task_manager_backend.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity, String> {

}

