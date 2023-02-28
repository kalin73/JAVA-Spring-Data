package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
	@Column(nullable = false)
	private String name;

	@Column
	private String comment;

	public Diagnose() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
