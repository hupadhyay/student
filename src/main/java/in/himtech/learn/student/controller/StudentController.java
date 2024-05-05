package in.himtech.learn.student.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import in.himtech.learn.student.domain.Student;
import in.himtech.learn.student.service.MyConfig;
import in.himtech.learn.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@RequestMapping(value="/studentList")
	public String getHelloPage(ModelMap modelMap) {
		List<Student> allStudents = service.getAllStudents();
		modelMap.addAttribute("students",allStudents);
		return "students";
	}
	
	@RequestMapping(value="/add-student", method = RequestMethod.GET)
	public String getNewStudentForm(ModelMap modelMap) {
		Student stdnt = new Student(0, "", "", "",LocalDate.now(), Boolean.FALSE);
		modelMap.addAttribute("student",stdnt);
		return "addStudent";
	}
	
	@RequestMapping(value="/add-student", method = RequestMethod.POST)
	public String submitStudentForm(ModelMap modelMap,@Valid Student stdnt, BindingResult result) {
		if(result.hasErrors()) {
			return "addStudent";
		}
		this.service.addStudent(stdnt);
		return "redirect:/studentList";
	}
	
	@RequestMapping(value="/delete-student/{stdId}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Integer stdId, ModelMap modelMap) {
		this.service.deleteStudent(stdId);
		return "redirect:/studentList";
	}
	
	@RequestMapping(value="/update-student/{stdId}", method = RequestMethod.GET)
	public String updateStudent(@PathVariable Integer stdId, ModelMap modelMap) {
		Student student = this.service.getStudentById(stdId);
		modelMap.addAttribute("student",student);
		return "addStudent";
	}

	@RequestMapping(value="/update-student/{stdId}", method = RequestMethod.POST)
	public String submitUpdateStudent(ModelMap modelMap, @Valid Student stdnt, BindingResult result) {
		if(result.hasErrors()) {
			return "addStudent";
		}
		this.service.updateStudent(stdnt);
		return "redirect:/studentList";
	}
	
	@RequestMapping(value="/map", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getErrorStaus() {
		
		return this.service.getErrorMap();
		
	}
}
