package br.com.caelum.vraptor.poc.converter;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.caelum.vraptor.poc.model.Department;

@Convert(Department.class)
@ApplicationScoped
public class DepartmentConverter implements Converter<Department> {

	@Override
	public Department convert(final String value, final Class<? extends Department> type) {
		if (value != null) {
			return (value.isEmpty()) ? null : new Department(Long.parseLong(value));
		}

		return new Department();
	}
}
