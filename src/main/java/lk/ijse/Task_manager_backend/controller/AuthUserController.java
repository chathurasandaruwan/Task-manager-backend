package lk.ijse.Task_manager_backend.controller;

import lk.ijse.Task_manager_backend.dto.impl.UserDTO;
import lk.ijse.Task_manager_backend.exeption.DataPersistException;
import lk.ijse.Task_manager_backend.secure.JWTAuthResponse;
import lk.ijse.Task_manager_backend.secure.SignIn;
import lk.ijse.Task_manager_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("api/v1/auth/")
@RestController
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;

    //signup
    @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> saveUser(@RequestBody UserDTO userDTO) {
        try {
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            // call service layer
            return ResponseEntity.ok(authService.signUp(userDTO));
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //login
    @PostMapping(value = "signin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignIn signIn) {
        System.out.println(signIn);
        //todo: call service layer
        return null;
    }

}
