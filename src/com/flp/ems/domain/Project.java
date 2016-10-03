package com.flp.ems.domain;

public class Project {

	private int projectId;
	private String name;
	private String description;
	private Department department;
	
	public Project(int projectId, String name, String description, Department department) {
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.department = department;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Department getDepartment() {
		return department;
	}
}
