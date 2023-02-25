package entities;

import jakarta.persistence.*;

@Entity
public class Bike extends Vehicle {
	private static final String TYPE = "BIKE";

	public Bike() {
		super(TYPE);
	}

}
