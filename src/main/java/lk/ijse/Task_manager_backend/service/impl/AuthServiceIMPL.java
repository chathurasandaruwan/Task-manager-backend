package lk.ijse.Task_manager_backend.service.impl;


import lk.ijse.Task_manager_backend.dao.UserDAO;
import lk.ijse.Task_manager_backend.dto.impl.UserDTO;
import lk.ijse.Task_manager_backend.entity.impl.UserEntity;
import lk.ijse.Task_manager_backend.exeption.UserNotFoundException;
import lk.ijse.Task_manager_backend.secure.JWTAuthResponse;
import lk.ijse.Task_manager_backend.secure.SignIn;
import lk.ijse.Task_manager_backend.service.AuthService;
import lk.ijse.Task_manager_backend.service.JWTService;
import lk.ijse.Task_manager_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final UserDAO userDAO;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        UserEntity user = userDAO.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        var generateToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder()
                .token(generateToken)
                .userId(user.getUserId())
                .build();
    }

    @Override
    public JWTAuthResponse signUp(UserDTO userDTO) {
//        saveUser
        UserEntity savedUser = userDAO.save(mapping.toUserEntity(userDTO));
//        generate token and return
        var generateToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder()
                .token(generateToken)
                .userId(savedUser.getUserId())
                .build();
    }

    @Override
    public JWTAuthResponse refreshToken(String accessToken) {
//        extractUsername
        var username = jwtService.extractUsername(accessToken);
//        is exists the User
        UserEntity user = userDAO.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        var generateToken = jwtService.refreshToken(user);
        return JWTAuthResponse.builder().token(generateToken).build();
    }
}
