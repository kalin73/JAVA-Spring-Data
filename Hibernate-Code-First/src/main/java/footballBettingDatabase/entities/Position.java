package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Position {
	@Id
	@Column(length = 2)
	private String id;

	@Column
	private String description;

	public Position() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
