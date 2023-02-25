package entities;

import jakarta.persistence.*;

@Entity
public class Plane extends Vehicle {
	private static final String TYPE = "PLANE";

	@Column(name = "passenger_capatity")
	private int passengerCapacity;

	public Plane() {
		super(TYPE);
	}

	public Plane(String model, String fuelType, int passengerCapacity) {
		this();

		this.model = model;
		this.fuelType = fuelType;
		this.passengerCapacity = passengerCapacity;

	}

	public Plane(int passengerCapactity) {
		this.passengerCapacity = passengerCapactity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

}
