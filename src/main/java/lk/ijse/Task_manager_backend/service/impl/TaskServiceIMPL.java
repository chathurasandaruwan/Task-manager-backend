package lk.ijse.Task_manager_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Task_manager_backend.dao.TaskDAO;
import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskDAO taskDAO;

    @Override
    public void saveTask(TaskDTO taskDTO) {

    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return null;
    }

    @Override
    public void deleteTask(String taskId) {

    }

    @Override
    public void updateTask(String taskId, TaskDTO taskDTO) {

    }

    @Override
    public TaskDTO getSelectedTaskById(String id) {
        return null;
    }
}
