package com.ilyassov.repository;

import com.ilyassov.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {

    public List<User> getUsers();
    public List<User> getUserById(int id);
}
