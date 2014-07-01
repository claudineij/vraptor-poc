package br.com.caelum.vraptor.poc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.poc.model.Department;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@Path("/department")
public class DepartmentController {

	@Inject
	private Result result;

	@Inject
	private Validator validator;

	@Get
	public void form() {

	}

	@Post
	public void save(final Department department) {
		result.include("success", new SimpleMessage("department", "Create department: " + department.getName()));
		result.redirectTo(this).form();
	}

}
