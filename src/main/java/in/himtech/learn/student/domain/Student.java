package in.himtech.learn.student.domain;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Student {
	private Integer id;
	
	@Size(min = 8, message = "must be 8 character long")
	private String userName;
	
	private String fullName;
	
	@Email(message = "must be a valid email-id")
	private String email;
	
	@Past(message = "Date must be in past")
	private LocalDate doj;
	
	private Boolean isGraduated;
	
	public Student() {
		super();
	}

	public Student(Integer id, String userName, String fullName, String email, LocalDate doj, Boolean isGraduated) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.doj = doj;
		this.isGraduated = isGraduated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public Boolean getIsGraduated() {
		return isGraduated;
	}

	public void setIsGraduated(Boolean isGraduated) {
		this.isGraduated = isGraduated;
	}

	@Override
	public String toString() {
		return String.format("Student [id=%s, userName=%s, fullName=%s, email=%s, doj=%s, isGraduated=%s]", id,
				userName, fullName, email, doj, isGraduated);
	}
	
}
