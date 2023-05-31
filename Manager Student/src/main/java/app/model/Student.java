package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student { //id

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	protected String code;
	protected String name;
	protected Integer age;
	protected String email;
	protected String branch;

	public Student(){

	}

	public Student(String name, Integer age, String email, String id, String branch, String code) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.code = code;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}