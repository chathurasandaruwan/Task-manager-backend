package lk.ijse.Task_manager_backend.util;

import lk.ijse.Task_manager_backend.dto.impl.TaskDTO;
import lk.ijse.Task_manager_backend.dto.impl.UserDTO;
import lk.ijse.Task_manager_backend.entity.impl.TaskEntity;
import lk.ijse.Task_manager_backend.entity.impl.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    //    for task mapping
    public TaskDTO toTaskDTO(TaskEntity task){
        return mapper.map(task,TaskDTO.class);
    }
    public TaskEntity toTaskEntity(TaskDTO task){
        return mapper.map(task,TaskEntity.class);
    }

    public List<TaskDTO> asTaskDTOList(List<TaskEntity> all) {
        return mapper.map(all, new TypeToken<List<TaskDTO>>(){}.getType());
    }
    // for user mapping
    public UserEntity toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO,UserEntity.class);
    }

}
