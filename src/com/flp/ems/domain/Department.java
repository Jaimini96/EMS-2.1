package com.flp.ems.domain;

public class Department {
	
	private int departmentId;
	private String name;
	private String description;
	
	public Department(int departmentId, String name, String description) {
		this.departmentId = departmentId;
		this.name = name;
		this.description = description;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
