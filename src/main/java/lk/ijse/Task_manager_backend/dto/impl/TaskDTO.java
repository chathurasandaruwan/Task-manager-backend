package lk.ijse.Task_manager_backend.dto.impl;

import lk.ijse.Task_manager_backend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements TaskStatus {
    private String taskId ;
    private String title;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;
}
