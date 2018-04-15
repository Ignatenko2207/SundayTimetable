package org.itstep.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table( name = "STUDENTS" )
public class Student extends User {

	@ManyToOne( targetEntity = Group.class )
	private Group group;
}
