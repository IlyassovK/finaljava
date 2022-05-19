package com.ilyassov.service;

import com.ilyassov.aop.AopToken;
import com.ilyassov.model.User;
import com.ilyassov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
@Profile("dev")
@EnableScheduling
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @AopToken
    @Cacheable(value = "users")
    @Transactional(rollbackFor = {SQLException.class},
            isolation = Isolation.DEFAULT
    )
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public List<User> getUsersById(int id) {
        return userRepository.getUserById(id);
    }

    ;

    public User addUser(User user) {
        return userRepository.addUser(user);
    }
}
