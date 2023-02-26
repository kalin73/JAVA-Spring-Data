package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "competition_type")
public class CompetitonType extends BaseEntity {
	@Column
	private String name;

	public CompetitonType() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
