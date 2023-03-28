package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.dtos.address.AddressXMLDto;
import com.example.demo.entities.dtos.address.CountryXmlDto;

import jakarta.xml.bind.*;

//@Component
public class XmlTestMain implements CommandLineRunner {
	private final JAXBContext addressJaxbContext;
	private final JAXBContext countryContext;

	public XmlTestMain(@Qualifier("addressContext") JAXBContext addressJaxbContext, JAXBContext countryContext) {
		this.addressJaxbContext = addressJaxbContext;
		this.countryContext = countryContext;
	}

	@Override
	public void run(String... args) throws Exception {
		CountryXmlDto country = new CountryXmlDto("Bulgaria");
		AddressXMLDto xmlDto = new AddressXMLDto(5, "Bulgaria", "Vidin");

	//	JAXBContext context = JAXBContext.newInstance(AddressXMLDto.class);
		Marshaller countryMarshaller = countryContext.createMarshaller();
		countryMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		countryMarshaller.marshal(country, System.out);
		
		Marshaller addressMarshaller = addressJaxbContext.createMarshaller();
		addressMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		addressMarshaller.marshal(xmlDto, System.out);

	//	Unmarshaller unmarshaller = context.createUnmarshaller();

	//	AddressXMLDto inputObj = (AddressXMLDto) unmarshaller.unmarshal(System.in);

		
	}
}
