package com.ilyassov.contoller;

import com.ilyassov.model.Role;
import com.ilyassov.model.User;
import com.ilyassov.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/getAllRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<Role> getAll() throws SQLException {
        return roleService.getRoles();
    }
}
