package in.himtech.learn.student.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import in.himtech.learn.student.domain.Student;
import in.himtech.learn.student.exception.ResourceNotFoundException;

@PropertySource("classpath:invAdd.properties")
@ConfigurationProperties(prefix = "invoice-add")
@Service
public class StudentService {

	private Map<String, String> errorMap = new HashMap<>();

	public List<Student> listStudents = new ArrayList<>();

	public StudentService() {
		listStudents.add(new Student(1, "hupadhyay", "Himanshu Upadhyay", "himanshu@himtech.com",
				LocalDate.of(2001, 3, 4), Boolean.TRUE));
		listStudents.add(new Student(2, "hskupadhyay", "Hrishik Upadhyay", "hsk@himtech.com", LocalDate.of(2021, 5, 10),
				Boolean.FALSE));
		listStudents.add(new Student(3, "htkupadhyay", "Hritika Upadhyay", "htk@himtech.com",
				LocalDate.of(2018, 11, 10), Boolean.FALSE));
	}

	public List<Student> getAllStudents() {
		return listStudents;
	}

	public void addStudent(Student stdnt) {
		int maxId = -1;
		if (listStudents.size() == 0) {
			maxId = 1;
		} else {
			maxId = listStudents.stream().mapToInt(Student::getId).max().getAsInt();
		}
		stdnt.setId(maxId);
		listStudents.add(stdnt);
	}

	public void deleteStudent(Integer stdId) {
		Optional<Student> optStudent = this.listStudents.stream().filter(s -> s.getId().equals(stdId)).findAny();
		if (optStudent.isPresent()) {
			this.listStudents.remove(optStudent.get());
		} else {
			throw new ResourceNotFoundException("Student with id " + stdId + " not Found!");
		}
	}

	public Student getStudentById(Integer stdId) {
		return this.listStudents.stream().filter(s -> s.getId().equals(stdId)).findAny()
				.orElseThrow(() -> new ResourceNotFoundException("Student with id " + stdId + " not Found!"));
	}

	public void updateStudent(Student stdnt) {
		Optional<Student> optStudent = this.listStudents.stream().filter(s -> s.getId().equals(stdnt.getId()))
				.findAny();
		if (optStudent.isPresent()) {
			Student savedStu = optStudent.get();
			savedStu.setDoj(stdnt.getDoj());
			BeanUtils.copyProperties(stdnt, savedStu);
		} else {
			throw new ResourceNotFoundException("Student with id " + stdnt.getId() + " not Found!");
		}
	}
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}
}
