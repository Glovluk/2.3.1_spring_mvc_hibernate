package com.glovluk.service;

import com.glovluk.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void delete(Long id);
}
