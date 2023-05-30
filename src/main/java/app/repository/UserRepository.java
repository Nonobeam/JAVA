package app.repository;

import app.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Student, Long> {
    Iterable<Student> findByBranch(String branch);
}
