package br.com.caelum.vraptor.poc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

public class Department {

	private Long id;

	private String name;

	@ManyToMany
	private List<Employee> responsibles;

	public Department(final Long id) {
		this.responsibles = new ArrayList<>();
	}

	public Department(final Long id, final String name, final List<Employee> responsibles) {
		this.id = id;
		this.name = name;
		this.responsibles = responsibles;
	}

	public Department() {

	}

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

	public List<Employee> getResponsibles() {
		return responsibles;
	}

	public void setResponsibles(final List<Employee> responsibles) {
		this.responsibles = responsibles;
	}
}
