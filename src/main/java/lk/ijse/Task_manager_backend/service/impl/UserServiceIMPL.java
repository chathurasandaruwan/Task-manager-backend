package lk.ijse.Task_manager_backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.Task_manager_backend.dao.UserDAO;
import lk.ijse.Task_manager_backend.exeption.UserNotFoundException;
import lk.ijse.Task_manager_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userDAO.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }
}
