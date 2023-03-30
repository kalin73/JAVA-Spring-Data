package com.softuni.jsonexercise.constant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public enum Utils {
	;
	public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static ModelMapper modelMapper = new ModelMapper();

	public static void writeJsonIntoFile(List<?> objects, File file) throws IOException {
		final FileWriter writer = new FileWriter(file);

		gson.toJson(objects, writer);

		writer.flush();
		writer.close();
	}

	public static void writeJsonIntoFile(Object object, File file) throws IOException {
		final FileWriter writer = new FileWriter(file);

		gson.toJson(object, writer);

		writer.flush();
		writer.close();
	}

	public static <T> void writeXmlIntoFile(T data, File file) throws IOException, JAXBException {
		final FileWriter writer = new FileWriter(file);

		final JAXBContext context = JAXBContext.newInstance(data.getClass());
		final Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(data, writer);

		writer.flush();
		writer.close();
	}

}
