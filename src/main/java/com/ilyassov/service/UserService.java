package com.ilyassov.service;

import com.ilyassov.model.User;
import com.ilyassov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){ return userRepository.getUsers(); }
    public List<User> getUsersById(int id){ return userRepository.getUserById(id); };
}
