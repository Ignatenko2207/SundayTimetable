package org.itstep.controller;

import java.awt.PageAttributes.MediaType;

import org.itstep.model.Student;
import org.itstep.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
		@Autowired
		StudentService studentService;
		
		@PostMapping
		ResponseEntity save(@RequestParam Student student) {
			if(studentService.save(student) != null) {
				return new ResponseEntity(HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		@PutMapping
		ResponseEntity update(@RequestParam Student student) {
			if(studentService.update(student) != null) {
				return new ResponseEntity(HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		@GetMapping( path = "/get-one")
		ResponseEntity<Student> getOne(@RequestParam String login) {
			Student student = studentService.get(login);
			if( student != null) {
				return new ResponseEntity(student, HttpStatus.OK);
			}
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		@DeleteMapping
		ResponseEntity delete(@RequestParam String login) {
			studentService.delete(login);
			return new ResponseEntity(HttpStatus.OK);
		}
	
}
