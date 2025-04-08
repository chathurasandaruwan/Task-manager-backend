package lk.ijse.Task_manager_backend.controller;

import lk.ijse.Task_manager_backend.customStatusCode.SelectedTasckErrorStatus;
import lk.ijse.Task_manager_backend.dto.TaskStatus;
import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.exeption.DataPersistException;
import lk.ijse.Task_manager_backend.exeption.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    //save task
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveTask(
            @RequestPart("title") String title,
            @RequestPart("description")String description,
            @RequestPart("status") String status,
            @RequestPart("createdAt")String createdAt,
            @RequestPart("updatedAt") String updatedAt
    ){
        try {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTitle(title);
            taskDTO.setDescription(description);
            taskDTO.setStatus(status);
            taskDTO.setCreatedAt(createdAt);
            taskDTO.setUpdatedAt(updatedAt);
            //call service layer
            System.out.println(taskDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //getAll tasks
    @GetMapping(value = "/getAllTasks",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAllTasks(){
        return null;
    }

    //update task
    @PutMapping(value = "/{taskId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateTask(
            @RequestPart("title") String title,
            @RequestPart("description")String description,
            @RequestPart("status") String status,
            @RequestPart("createdAt")String createdAt,
            @RequestPart("updatedAt") String updatedAt,
            @PathVariable String taskId){
        try {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setTitle(title);
            taskDTO.setDescription(description);
            taskDTO.setStatus(status);
            taskDTO.setCreatedAt(createdAt);
            taskDTO.setUpdatedAt(updatedAt);
            //call service layer
            System.out.println(taskDTO+" "+taskId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (TaskNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //delete task
    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskId){
        try {
            //call service layer
            System.out.println(taskId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (TaskNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //get task by id
    @GetMapping(value = "/{taskId}")
    public TaskStatus getTaskById(@PathVariable String taskId){
        try {
            //call service layer
            System.out.println(taskId);
            return new SelectedTasckErrorStatus(0, "Task Found");
        }catch (TaskNotFoundException e){
            e.printStackTrace();
            return new SelectedTasckErrorStatus(1, "Task Not Found");
        }
    }
}
