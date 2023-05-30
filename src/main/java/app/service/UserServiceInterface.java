package app.service;


import app.model.Student;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceInterface implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Student create(Student user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public Student update(Long id, Student user) {
        Student UpdateDB = userRepository.findById(id).orElse(null);
        if (UpdateDB == null){
            return null;
        }

        UpdateDB.setName(user.getName());
        UpdateDB.setAge(user.getAge());
        UpdateDB.setEmail(user.getEmail());

        return userRepository.save(UpdateDB);
    }

    @Override
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    @Override
//    public Iterable<Student> findByBranch(String branch) {
//        List<Student> students = new ArrayList<>();
//        for(Student student: students){
//            userRepository.
//        }
//    }
}
