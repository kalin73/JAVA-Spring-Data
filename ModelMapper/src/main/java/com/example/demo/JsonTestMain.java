package com.example.demo;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;

import com.example.demo.entities.dtos.Company;
import com.example.demo.entities.dtos.CreateEmployeeDTO;
import com.example.demo.entities.dtos.addresses.CreateAddressDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//@Component
public class JsonTestMain implements CommandLineRunner {
	private Gson gson;
	private final Scanner sc;

	public JsonTestMain() {
		gson = new GsonBuilder()
			    .excludeFieldsWithoutExposeAnnotation()
				.setDateFormat("YYYY-MM-DD")
				//.setPrettyPrinting()
				.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
		sc = new Scanner(System.in);
	}

	@Override
	public void run(String... args) throws Exception {
		CreateAddressDTO address1 = new CreateAddressDTO("Bulgaria", "Burgas");
		CreateEmployeeDTO employee1 = new CreateEmployeeDTO("First", "Last", BigDecimal.TEN, LocalDate.now(), address1);

		CreateAddressDTO address2 = new CreateAddressDTO("Bulgaria", "Sofia");
		CreateEmployeeDTO employee2 = new CreateEmployeeDTO("Second", "Last", BigDecimal.TEN, LocalDate.now(),
				address2);

		CreateAddressDTO address3 = new CreateAddressDTO("Bulgaria", "Povdiv");
		CreateEmployeeDTO employee3 = new CreateEmployeeDTO("Third", "Last", BigDecimal.TEN, LocalDate.now(), address3);

		Company mega = new Company("Mega", List.of(employee1, employee2, employee3));

		System.out.println(this.gson.toJson(mega));

		String input = sc.nextLine();
		Company parsed = this.gson.fromJson(input, Company.class);
		
		System.out.println(parsed);
	}

	public void test1() {
		CreateAddressDTO address1 = new CreateAddressDTO("Bulgaria", "Burgas");
//		CreateAddressDTO address2 = new CreateAddressDTO("Bulgaria", "Sofia");
//		CreateAddressDTO address3 = new CreateAddressDTO("Bulgaria", "Povdiv");

		CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO("First", "Last", BigDecimal.TEN, LocalDate.now(),
				address1);

		String json = gson.toJson(createEmployeeDTO);

		System.out.println(json);

		String input = sc.nextLine();

		CreateAddressDTO[] arr = gson.fromJson(input, CreateAddressDTO[].class);
		
		for(CreateAddressDTO dto : arr) {
			System.out.println(dto);
		}
	}
}

class LocalDateAdapter implements JsonSerializer<LocalDate> {
	@Override
	public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
	}
}
