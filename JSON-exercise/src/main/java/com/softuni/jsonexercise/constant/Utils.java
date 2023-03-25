package com.softuni.jsonexercise.constant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public enum Utils {
	;
	public static Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

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
}
