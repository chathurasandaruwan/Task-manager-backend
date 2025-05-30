package lk.ijse.Task_manager_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Task_manager_backend.dao.TaskDAO;
import lk.ijse.Task_manager_backend.dto.TaskStatus;
import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.entity.impl.TaskEntity;
import lk.ijse.Task_manager_backend.service.TaskService;
import lk.ijse.Task_manager_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public TaskDTO saveTask(TaskDTO taskDTO) {
        TaskEntity taskEntity = mapping.toTaskEntity(taskDTO);
        taskEntity.setCreatedAt(LocalDate.now());
        taskEntity.setUpdatedAt(LocalDate.now());

        TaskEntity saveTask = taskDAO.save(taskEntity);
        if (saveTask == null) {
            throw new RuntimeException("Failed to save task");
        }
        return mapping.toTaskDTO(saveTask);
    }

    @Override
    public List<TaskDTO> getAllTasks(String userId) {
        return mapping.asTaskDTOList(taskDAO.findByUserUserId(userId));
    }

    @Override
    public void deleteTask(String taskId) {
        Optional<TaskEntity> byId = taskDAO.findById(taskId);
        if (!byId.isPresent()) {
            throw new RuntimeException("Task not found");
        } else {
            taskDAO.deleteById(taskId);
        }
    }

    @Override
    public void updateTask(String taskId, TaskDTO taskDTO) {
        Optional<TaskEntity> byId = taskDAO.findById(taskId);
        if (!byId.isPresent()) {
            throw new RuntimeException("Task not found");
        } else {
            byId.get().setTitle(taskDTO.getTitle());
            byId.get().setDescription(taskDTO.getDescription());
            byId.get().setStatus(taskDTO.getStatus());
            byId.get().setUpdatedAt(LocalDate.now());
        }
    }

    @Override
    public TaskDTO getSelectedTaskById(String id) {
        Optional<TaskEntity> byId = taskDAO.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Task not found");
        } else {
            return mapping.toTaskDTO(byId.get());
        }
    }
}
