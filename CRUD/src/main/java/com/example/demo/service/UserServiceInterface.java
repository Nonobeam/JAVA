package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.Users;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceInterface implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users create(Users user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public Users update(Long id, Users user) {
        Users UpdateDB = userRepository.findById(id).orElse(null);
        if (UpdateDB == null){
            return null;
        }

        UpdateDB.setName(user.getName());
        UpdateDB.setAge(user.getAge());
        UpdateDB.setEmail(user.getEmail());
//        UpdateDB.setAlumniCode(user.getAlumniCode());

        return userRepository.save(UpdateDB);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
