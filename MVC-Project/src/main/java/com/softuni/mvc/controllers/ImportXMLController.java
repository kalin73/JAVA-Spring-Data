package com.softuni.mvc.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.softuni.mvc.services.CompanyService;
import com.softuni.mvc.services.EmployeeService;
import com.softuni.mvc.services.ProjectService;

import jakarta.xml.bind.JAXBException;

@Controller
public class ImportXMLController {
	private final CompanyService companyService;
	private final ProjectService projectService;
	private final EmployeeService employeeService;

	public ImportXMLController(CompanyService companyService, ProjectService projectService,
			EmployeeService employeeService) {
		this.companyService = companyService;
		this.projectService = projectService;
		this.employeeService = employeeService;
	}

	@GetMapping("import/xml")
	public String index(Model model) {
		boolean companiesImported = this.companyService.areImported();
		boolean projectsImported = this.projectService.areImported();
		boolean employeesImported = this.employeeService.areImported();

		boolean[] importStatuses = new boolean[] { companiesImported, projectsImported, employeesImported };

		model.addAttribute("areImported", importStatuses);

		return "xml/import-xml";
	}

	@GetMapping("/import/companies")
	public String viewImportCompanies(Model model) throws IOException {
		final String companiesXML = this.companyService.getXMLContent();
		model.addAttribute("companies", companiesXML);

		return "xml/import-companies";
	}

	@PostMapping("/import/companies")
	public String importCompanies() throws IOException, JAXBException {
		this.companyService.importCompanies();

		return "redirect:/import/xml";
	}

	@GetMapping("/import/projects")
	public String viewImportProjects(Model model) throws IOException {
		final String projectXML = this.projectService.getXMLContent();
		model.addAttribute("projects", projectXML);

		return "xml/import-projects";

	}

	@PostMapping("/import/projects")
	public String importProjects() throws JAXBException, IOException {
		this.projectService.importProjects();

		return "redirect:/import/xml";
	}

	@GetMapping("/import/employees")
	public String viewImportEmployees(Model model) throws IOException {
		final String employeesXML = this.employeeService.getXMLContent();
		model.addAttribute("employees", employeesXML);

		return "xml/import-employees";

	}

	@PostMapping("/import/employees")
	public String importEmployees() throws JAXBException, IOException {
		this.employeeService.importEmployees();

		return "redirect:/import/xml";
	}
}
