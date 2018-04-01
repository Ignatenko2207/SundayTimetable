package org.itstep.service.impl;

import java.util.List;

import org.itstep.dao.AdminDAO;
import org.itstep.model.Admin;
import org.itstep.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;
	
	public Admin save(Admin admin) {
		if(adminDAO.getOne(admin.getLogin()) == null) {
			return adminDAO.save(admin);
		}
		return null;
	}

	public Admin update(Admin admin) {
		if(adminDAO.getOne(admin.getLogin()) != null) {
			return adminDAO.save(admin);
		}
		return null;
	}

	public Admin get(String login) {		
		return adminDAO.getOne(login);
	}

	public List<Admin> findAllByLocation(String location) {		
		return adminDAO.findAllByLocation(location);
	}

	public void delete(String login) {
		adminDAO.delete(login);
	}

}