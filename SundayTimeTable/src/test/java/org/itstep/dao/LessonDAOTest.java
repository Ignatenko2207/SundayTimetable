package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import org.itstep.ApplicationRunner;
import org.itstep.model.Group;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LessonDAOTest {

	private Subject subject;

	private Teacher teacher;

	private Group group;

	private List<Lesson> lessons = new ArrayList<Lesson>();

	@Autowired
	LessonDAO lessonDAO;

	@Autowired
	GroupDAO groupDAO;

	@Autowired
	TeacherDAO teacherDAO;

	@Autowired
	SubjectDAO subjectDAO;

	@Before
	public void setUp() throws Exception {
		Subject sub = new Subject();
		sub.setName("Python");
		subject = subjectDAO.save(sub);

		Teacher teach = new Teacher();
		teach.setLogin("Ignatenko2207");
		teach.setPassword("123456");
		teach.setFirstName("Alex");
		teach.setSecondName("Ignatenko");
		teach.setSubject(subject);
		teacher = teacherDAO.save(teach);

		Group gr = new Group();
		gr.setName("B9P1_26");
		gr.setSpecialization("Software development");
		gr.setCourse("year course");
		group = groupDAO.save(gr);

		for (int i = 1; i <= 3; i++) {
			Lesson less = new Lesson();
			less.setCabinet("16");
			less.setStartTime((long)45*i);
			less.setGroup(group);
			less.setTeacher(teacher);
			less.setSubject(subject);
			
			lessons.add(lessonDAO.save(less));
		}

	}

	@Test
	public void testFindAllByStartTime() {
		List<Lesson> testLessons = lessonDAO.findAllByStartTime(0L, 100L);
		assertNotNull(testLessons);
		assertEquals(2, testLessons.size());
		assertEquals("Python", testLessons.get(0).getTeacher().getSubject().getName());
		
		List<Lesson> allTestLessons = lessonDAO.findAllByStartTime(0L, 150L);
		assertNotNull(allTestLessons);
		assertEquals(3, allTestLessons.size());
	}

	@After
	public void tearDown() throws Exception {
		for (Lesson lesson : lessons) {
			lessonDAO.delete(lesson);
		}
		groupDAO.delete(group);
		teacherDAO.delete(teacher);
		subjectDAO.delete(subject);
	}
}
