package br.com.caelum.vraptor.poc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.ManyToMany;

public class Department {

	private Long id;

	private String name;

	@ManyToMany
	private List<Employee> responsibles;

	public Department() {
		this.responsibles = new ArrayList<>();
	}

	public Department(Long id) {
		this.id = id;
		this.responsibles = new ArrayList<>();
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
