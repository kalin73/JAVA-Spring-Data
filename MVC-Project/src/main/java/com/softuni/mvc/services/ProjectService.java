package com.softuni.mvc.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.mvc.models.dtos.projects.FinalizedProjectDto;
import com.softuni.mvc.models.dtos.projects.ImportProjectsDto;
import com.softuni.mvc.models.entities.Project;
import com.softuni.mvc.repositories.CompanyRepository;
import com.softuni.mvc.repositories.ProjectRepository;
import com.softuni.mvc.utils.ValidationUtil;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	private final ValidationUtil validationUtil;
	private final CompanyRepository companyRepository;

	public ProjectService(ProjectRepository projectRepository, ModelMapper modelMapper, ValidationUtil validationUtil,
			CompanyRepository companyRepository) {
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
		this.companyRepository = companyRepository;
	}

	public String getXMLContent() throws IOException {
		Path path = Path.of("src", "main", "resources", "files", "xmls", "projects.xml");
		List<String> lines = Files.readAllLines(path);

		return String.join("\n", lines);
	}

	public void importProjects() throws JAXBException, IOException {
		String xmlContent = getXMLContent();
		ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

		JAXBContext context = JAXBContext.newInstance(ImportProjectsDto.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		ImportProjectsDto projects = (ImportProjectsDto) unmarshaller.unmarshal(stream);

		List<Project> entities = projects.getProjects()
				.stream()
				.filter(this.validationUtil::isValid)
				.map(project -> modelMapper.map(project, Project.class))
				.filter(project -> this.companyRepository.findFirstByName(project.getCompany().getName()).isPresent())
				.map(project -> new Project(project.getName(),
						project.getDescription(),
						project.isFinished(),
						project.getPayment(),
						project.getStartDate(),
						this.companyRepository.findFirstByName(project.getCompany().getName()).get()))
				.toList();

		this.projectRepository.saveAll(entities);

	}
	
	public boolean areImported() {
		return this.projectRepository.count() > 0;

	}
	
	public String getFinalizedProjects() {
		return this.projectRepository.findAllByIsFinished(true).orElseThrow(NoSuchElementException::new)
				.stream()
				.map(project -> this.modelMapper.map(project, FinalizedProjectDto.class))
				.map(project -> project.toString())
				.collect(Collectors.joining(System.lineSeparator()));
		
	}
}
