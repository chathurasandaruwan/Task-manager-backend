package lk.ijse.Task_manager_backend.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    private String taskId;
    @Column(unique = true)
    private String title;
    private String description;
    private String status;
    private String createdAt;
    private String updatedAt;

}
