package com.example.demo.service;


import com.example.demo.model.Users;

import java.util.Optional;

public interface UserService {
    Users create(Users users);
    Users update(Long id, Users user);
    void delete(Long id);
    Iterable<Users> findAll();

    Users findById(Long id);

}
