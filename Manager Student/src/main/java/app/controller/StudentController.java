package app.controller;


import app.model.Student;
import app.repository.StudentRepository;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class StudentController {

	@Autowired
	private UserService userService;

	@PostMapping
	public Student create(@RequestBody Student user){
		return userService.create(user);
	}

	@DeleteMapping
	public void delete(Long id){
		userService.delete(id);
	}

	@PutMapping("/{id}")
	public Student update(@PathVariable Long id, @RequestBody Student user) {
		return userService.update(id, user);
	}

	@GetMapping("/allAlumni")
	public Iterable<Student> findAll(){
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public Student findById (@PathVariable Long id) {
		return userService.findById(id);
	}
}