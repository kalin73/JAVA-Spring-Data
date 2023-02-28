package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {
	@Column(nullable = false)
	private String name;

	@ManyToMany(mappedBy = "medicaments")
	private Set<Patient> patients;

	public Medicament() {
		patients = new HashSet<>();
	}

	public Set<Patient> getPatients() {
		return new HashSet<>(patients);
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Medicament(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
