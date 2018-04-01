package org.itstep.model;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class User {

	private String login;
	
	private String password;
	
	private String firstName;
	
	private String secondName;
	
	private UserRole role;
	
}
