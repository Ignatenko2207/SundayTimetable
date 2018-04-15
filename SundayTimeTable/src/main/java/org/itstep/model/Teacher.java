package org.itstep.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table( name = "TEACHERS" )
public class Teacher extends User{
	
	@ManyToOne( targetEntity = Subject.class )
	private Subject subject;
}
