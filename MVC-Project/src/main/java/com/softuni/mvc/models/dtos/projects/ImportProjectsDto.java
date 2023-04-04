package com.softuni.mvc.models.dtos.projects;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportProjectsDto {
	
	@XmlElement(name = "project")
	private List<ImportProjectDto> projects;

	public ImportProjectsDto() {

	}

	public ImportProjectsDto(List<ImportProjectDto> projects) {
		this.projects = projects;
	}

	public List<ImportProjectDto> getProjects() {
		return projects;
	}

	public void setProjects(List<ImportProjectDto> projects) {
		this.projects = projects;
	}
}
