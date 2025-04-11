package lk.ijse.Task_manager_backend.controller;

import lk.ijse.Task_manager_backend.customStatusCode.SelectedTasckErrorStatus;
import lk.ijse.Task_manager_backend.dto.TaskStatus;
import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.exeption.DataPersistException;
import lk.ijse.Task_manager_backend.exeption.TaskNotFoundException;
import lk.ijse.Task_manager_backend.service.TaskService;
import lk.ijse.Task_manager_backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    //save task
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> saveTask(@RequestBody TaskDTO taskDTO) {
        String id = AppUtil.generateTaskId();
        taskDTO.setTaskId(id);
        try {
            //call service layer
            TaskDTO newTask = taskService.saveTask(taskDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //getAll tasks
    @GetMapping(value = "/getAllTasks/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAllTasks(@PathVariable String userId) {
        return taskService.getAllTasks(userId);
    }

    //update task
    @PutMapping(value = "/{taskId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateTask(
            @RequestBody TaskDTO taskDTO,
            @PathVariable String taskId) {
        try {
            //call service layer
            taskService.updateTask(taskId, taskDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //delete task
    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId) {
        try {
            //call service layer
            taskService.deleteTask(taskId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get task by id
    @GetMapping(value = "/{taskId}")
    public TaskStatus getTaskById(@PathVariable String taskId) {
        try {
            //call service layer
            return taskService.getSelectedTaskById(taskId);
        } catch (TaskNotFoundException e) {
            e.printStackTrace();
            return new SelectedTasckErrorStatus(1, "Task Not Found");
        }
    }
}
