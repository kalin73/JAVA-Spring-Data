package entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
	@Column(nullable = false)
	private String first_name;

	@Column(nullable = false)
	private String last_name;

	@Column
	private String address;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private Date date_of_birth;

	@Column
	private String picture;

	@Column(nullable = false)
	private Boolean has_insurance;

	@OneToMany
	@JoinTable(name = "patients_visitations")
	private Set<Visitation> visitation;

	@ManyToOne
	private Diagnose diagnose;
	
	@ManyToMany
	@JoinTable(name = "patients_medicaments",
			joinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "medicament_id",referencedColumnName = "id"))
	private Set<Medicament> medicaments;

	public Patient() {
		visitation = new HashSet<>();
		medicaments = new HashSet<>();
	}

	public Set<Medicament> getMedicaments() {
		return new HashSet<>(medicaments);
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Set<Visitation> getVisitation() {
		return new HashSet<>(visitation);
	}

	public void setVisitation(Set<Visitation> visitation) {
		this.visitation = visitation;
	}

	public Diagnose getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(Diagnose diagnose) {
		this.diagnose = diagnose;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Boolean getHas_insurance() {
		return has_insurance;
	}

	public void setHas_insurance(Boolean has_insurance) {
		this.has_insurance = has_insurance;
	}
}
