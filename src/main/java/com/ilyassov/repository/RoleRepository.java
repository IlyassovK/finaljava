package com.ilyassov.repository;

import com.ilyassov.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository {

    public List<Role> getAllRoles();
}
