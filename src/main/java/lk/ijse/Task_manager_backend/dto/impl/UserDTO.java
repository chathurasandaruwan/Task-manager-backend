package lk.ijse.Task_manager_backend.dto.impl;

import lk.ijse.Task_manager_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO {
    private String userId;
    private String email;
    private String password;
}
