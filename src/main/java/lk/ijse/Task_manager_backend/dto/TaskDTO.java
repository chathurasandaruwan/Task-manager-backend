package lk.ijse.Task_manager_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements Serializable {
    private String id;
    private String title;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;
}
