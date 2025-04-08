package lk.ijse.Task_manager_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Task_manager_backend.dao.TaskDAO;
import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.entity.impl.TaskEntity;
import lk.ijse.Task_manager_backend.service.TaskService;
import lk.ijse.Task_manager_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskDAO taskDAO;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveTask(TaskDTO taskDTO) {
        TaskEntity saveTask = taskDAO.save(mapping.toTaskEntity(taskDTO));
        if (saveTask == null) {
            throw new RuntimeException("Failed to save task");
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return mapping.asTaskDTOList(taskDAO.findAll());
    }

    @Override
    public void deleteTask(String taskId) {
        Optional<TaskEntity> byId = taskDAO.findById(taskId);
        if (!byId.isPresent()) {
            throw new RuntimeException("Task not found");
        }else {
            taskDAO.deleteById(taskId);
        }
    }

    @Override
    public void updateTask(String taskId, TaskDTO taskDTO) {

    }

    @Override
    public TaskDTO getSelectedTaskById(String id) {
        return null;
    }
}
