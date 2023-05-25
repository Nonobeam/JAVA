package com.example.demo.controller;


import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Users create(@RequestBody Users user){
        return userService.create(user);
    }

    @DeleteMapping
    public void delete(Long id){
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users user) {
        return userService.update(id, user);
    }

    @GetMapping("/allAlumni")
    public Iterable<Users> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users findById (@PathVariable Long id) {
        return userService.findById(id);
    }
}
