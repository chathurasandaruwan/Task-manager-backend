package lk.ijse.Task_manager_backend.customStatusCode;

import lk.ijse.Task_manager_backend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedTasckErrorStatus implements TaskStatus {
    private int statusCode;
    private String StatusMessage;
}
