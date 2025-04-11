package lk.ijse.Task_manager_backend.service;


import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO saveTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTasks(String userId);

    void deleteTask(String taskId);

    void updateTask(String taskId, TaskDTO taskDTO);

    TaskDTO getSelectedTaskById(String id);
}
