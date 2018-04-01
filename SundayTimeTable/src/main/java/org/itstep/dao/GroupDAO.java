package org.itstep.dao;

import org.itstep.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group, String>{

}
