package lk.ijse.Task_manager_backend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
