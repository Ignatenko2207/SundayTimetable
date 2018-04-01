package org.itstep.service;

import java.util.List;

import org.itstep.model.Admin;

public interface AdminService {
	
	Admin save(Admin admin);
	
	Admin update(Admin admin);
	
	Admin get(String login);
	
	List<Admin> findAllByLocation(String location);
	
	void delete(String login);

}