package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
	@Column
	private String colorName;

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return this.colorName;
	}
}
