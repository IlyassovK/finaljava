package com.ilyassov.service;

import com.ilyassov.model.Role;
import com.ilyassov.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Profile("dev")
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles(){ return roleRepository.getAllRoles(); }

}
