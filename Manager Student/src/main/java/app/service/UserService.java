package app.service;


import app.model.Student;

public interface UserService {
    Student create(Student student);
    Student update(Long id, Student user);
    void delete(Long id);
    Iterable<Student> findAll();
    Student findById(Long id);

}