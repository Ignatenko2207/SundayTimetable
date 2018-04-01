package org.itstep.controller;

import org.itstep.model.Teacher;
import org.itstep.model.Teacher;
import org.itstep.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@PostMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity save(@RequestParam Teacher teacher) {
		if(teacherService.save(teacher) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping( consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity update(@RequestParam Teacher teacher) {
		if(teacherService.update(teacher) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping( path = "/get-one", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
	ResponseEntity<Teacher> getOne(@RequestParam Integer id) {
		Teacher teacher = teacherService.get(id);
		if( teacher != null) {
			return new ResponseEntity(teacher, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping
	ResponseEntity delete(@RequestParam Integer id) {
		teacherService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
