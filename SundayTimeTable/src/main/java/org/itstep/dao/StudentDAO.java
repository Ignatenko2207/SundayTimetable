package org.itstep.dao;

import java.util.List;

import org.itstep.model.Lesson;
import org.itstep.model.Student;
import org.itstep.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface StudentDAO extends JpaRepository<Student, String> {

	List<Student> findAllByGroup(String groupName);
	List<Student> findsecondName(String secondName);
}
