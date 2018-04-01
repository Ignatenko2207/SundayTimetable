package org.itstep.model;

import lombok.Getter;

@Getter
public enum UserRole {

	STUDENT("student"),
	TEACHER("teacher"),
	ADMIN("admin");
	
	private final String role;
	
	private UserRole(String role) {
		this.role = role;
	}
}
