package org.itstep.controller;

import javax.security.auth.Subject;

import org.itstep.model.Lesson;
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
public class SubjectController {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity save(@RequestParam Subject subject) {

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity update(@RequestParam Subject subject) {

		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/get-one", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<Subject> getOne(@RequestParam Integer id) {
		// Subject subject = SubjectService.get(id);
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping
	ResponseEntity delete(@RequestParam Integer id) {
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
