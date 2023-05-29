package app.service;


import app.model.Users;

public interface UserService {
    Users create(Users users);
    Users update(Long id, Users user);
    void delete(Long id);
    Iterable<Users> findAll();

    Users findById(Long id);

}
