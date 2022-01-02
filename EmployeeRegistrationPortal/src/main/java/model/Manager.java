package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import enumeration.Department;

@Entity
@Table(name = "manager")
public class Manager {
	
	@Id
	private int mid;
	private Department dept;
}
