package org.itstep.dao;

import java.util.List;

import org.itstep.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String>{

	List<User> findAllByGroup(String groupName);
}
