package entities;

import jakarta.persistence.*;

@Entity
public class Car extends PassengerVehicle {
	private static final String TYPE = "CAR";

	public Car() {
		super(TYPE);
	}

	public Car(String model, String fuelType, int seats) {
		this();

		this.model = model;
		this.fuelType = fuelType;
		this.seats = seats;

	}

}
