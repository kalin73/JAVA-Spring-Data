package com.softuni.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.softuni.mvc.services.CompanyService;
import com.softuni.mvc.services.EmployeeService;
import com.softuni.mvc.services.ProjectService;

@Controller
public class HomeController {
	private final CompanyService companyService;
	private final ProjectService projectService;
	private final EmployeeService employeeService;

	public HomeController(CompanyService companyService, ProjectService projectService,
			EmployeeService employeeService) {
		this.companyService = companyService;
		this.projectService = projectService;
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("home")
	public String home(Model model) {
		boolean companiesImported = this.companyService.areImported();
		boolean projectsImported = this.projectService.areImported();
		boolean employeesImported = this.employeeService.areImported();

		boolean importStatuses = companiesImported && projectsImported && employeesImported;
		model.addAttribute("areImported", importStatuses);
		
		return "home";
	}
}
