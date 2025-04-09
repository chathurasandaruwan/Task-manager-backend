package lk.ijse.Task_manager_backend.service;


import lk.ijse.Task_manager_backend.dto.impl.UserDTO;
import lk.ijse.Task_manager_backend.secure.JWTAuthResponse;
import lk.ijse.Task_manager_backend.secure.SignIn;

public interface AuthService {
    JWTAuthResponse signIn(SignIn signIn);

    JWTAuthResponse signUp(UserDTO userDTO);

    JWTAuthResponse refreshToken(String accessToken);
}
