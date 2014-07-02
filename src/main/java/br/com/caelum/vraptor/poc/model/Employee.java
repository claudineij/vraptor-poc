package br.com.caelum.vraptor.poc.model;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class Employee {

	private Long id;

	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}
}
