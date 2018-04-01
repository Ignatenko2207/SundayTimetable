package org.itstep.dao;

import java.util.List;

import org.itstep.model.Admin;
import org.itstep.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminDAO extends JpaRepository<Admin, String> {	
	
	@Query(value = "SELECT * FROM admins WHERE location=?1", nativeQuery = true)
	List<Admin> findAllByLocation(String location);

}
