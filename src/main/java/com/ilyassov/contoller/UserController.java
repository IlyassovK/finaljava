package com.ilyassov.contoller;

import com.ilyassov.model.User;
import com.ilyassov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() throws SQLException {
        return userService.getUsers();
    }

    @GetMapping(value = "/getUserById")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserById(@RequestParam("id") int id) throws SQLException {
        List<User> user = userService.getUsersById(id);
        if (user.isEmpty()) throw new IllegalStateException();
        return user;
    }
}
