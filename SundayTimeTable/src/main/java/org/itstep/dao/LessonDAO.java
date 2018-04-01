package org.itstep.dao;

import java.util.List;

import org.itstep.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDAO extends JpaRepository<Lesson, Integer>{

	@Query(value = "SELECT * FROM lessons WHERE start_time>?1 AND start_time<?2", nativeQuery = true)
	List<Lesson> findAllByStartTime(Long startPeriod, Long endPeriod);
}
