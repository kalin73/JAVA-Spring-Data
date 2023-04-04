package com.softuni.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.softuni.mvc.services.EmployeeService;
import com.softuni.mvc.services.ProjectService;

@Controller
public class ExportController {
	private final ProjectService productService;
	private final EmployeeService employeeService;

	public ExportController(ProjectService productService, EmployeeService employeeService) {
		this.productService = productService;
		this.employeeService = employeeService;
	}

	@GetMapping("/export/project-if-finished")
	public String exportFinalizedProjects(Model model) {
		String finalizedProjects = this.productService.getFinalizedProjects();

		model.addAttribute("projectsIfFinished", finalizedProjects);

		return "export/export-project-if-finished";
	}

	@GetMapping("/export/employees-above")
	public String exportEmployeesAbove25(Model model) {
		String employeesOverAge = this.employeeService.getEmployeesOverAge();

		model.addAttribute("employeesAbove", employeesOverAge);

		return "export/export-employees-with-age";
	}
}
