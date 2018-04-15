package org.itstep.controller;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.ApplicationRunner;
import org.itstep.dao.SubjectDAO;
import org.itstep.dao.TeacherDAO;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.itstep.service.TeacherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TeacherControllerTest {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	private Subject subjectInDB;
	
	private List<Teacher> teachers = new ArrayList<Teacher>();
	
	@MockBean
	TeacherService teacherService;
	
	@Before
	public void setUpBefore(){
		Subject subject = new Subject();
		subject.setName("Delphi");
		subjectInDB = subject;	
		
		Teacher teacher1 = new Teacher();
		teacher1.setLogin("Ignatenko2207");
		teacher1.setPassword("123456");
		teacher1.setFirstName("Alex");;
		teacher1.setSecondName("Ignatenko");
		teacher1.setSubject(subjectInDB);
		teachers.add(teacher1);
		
		Teacher teacher2 = new Teacher();
		teacher2.setLogin("Ignatenko2207_2");
		teacher2.setPassword("123456");
		teacher2.setFirstName("Alex_2");;
		teacher2.setSecondName("Ignatenko_2");
		teacher2.setSubject(subjectInDB);
		teachers.add(teacher2);
	}
	@Test
	public void testFindAllBySubject() throws Exception {

		RequestEntity request = new RequestEntity<String>(subjectInDB.getName(), HttpMethod.GET, new URI("/teacher/get-by-subject"));
		
		Mockito.when(teacherService.findAllBySubject(Mockito.anyString())).thenReturn(teachers);
		ResponseEntity<List> response = testRestTemplate.exchange(request, List.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		Mockito.verify(teacherService).findAllBySubject(Mockito.anyString());
	}

}
