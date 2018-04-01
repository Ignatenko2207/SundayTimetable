package org.itstep.dao;

import java.util.List;

import org.itstep.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDAO extends JpaRepository<Teacher, String>{
	List<Teacher> findAllBySubject(String Subject);
}
