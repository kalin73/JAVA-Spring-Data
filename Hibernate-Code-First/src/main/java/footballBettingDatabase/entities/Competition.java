package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Competition extends BaseEntity {
	@Column
	private String name;

	@ManyToOne
	private CompetitonType type;

	public Competition() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompetitonType getType() {
		return type;
	}

	public void setType(CompetitonType type) {
		this.type = type;
	}

}
