package com.softuni.mvc.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.mvc.models.dtos.companies.ImportCompaniesDto;
import com.softuni.mvc.models.entities.Company;
import com.softuni.mvc.repositories.CompanyRepository;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Service
public class CompanyService {
	private ModelMapper mapper;
	private final CompanyRepository companyRepository;

	public CompanyService(ModelMapper mapper, CompanyRepository companyRepository) {
		this.mapper = mapper;
		this.companyRepository = companyRepository;
	}

	public String getXMLContent() throws IOException {
		return String.join("\n",
				Files.readAllLines(Path.of("src", "main", "resources", "files", "xmls", "companies.xml")));
	}

	public void importCompanies() throws IOException, JAXBException {
		String xmlContent = this.getXMLContent();
		ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

		JAXBContext context = JAXBContext.newInstance(ImportCompaniesDto.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ImportCompaniesDto companies = (ImportCompaniesDto) unmarshaller.unmarshal(stream);

		List<Company> entities = companies.getCompanies().stream().map(dto -> this.mapper.map(dto, Company.class))
				.collect(Collectors.toList());

		this.companyRepository.saveAll(entities);

		System.out.println();

	}

	public boolean areImported() {
		return this.companyRepository.count() > 0;

	}

}
