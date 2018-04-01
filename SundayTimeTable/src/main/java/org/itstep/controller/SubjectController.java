package org.itstep.controller;



import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.service.SubjectService;
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
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity save(@RequestParam Subject subject) {
		if(subjectService.save(subject) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity update(@RequestParam Subject subject) {
		if(subjectService.update(subject) != null) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/get-one", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<Subject> getOne(@RequestParam String name) {
		 Subject subject = subjectService.get(name);
		if( subject != null) {
			return new ResponseEntity(subject, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping
	ResponseEntity delete(@RequestParam String name ) {
		subjectService.delete(name);
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
