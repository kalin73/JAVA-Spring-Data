package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "colors")
public class Color extends BaseEntity {
	@Column
	private String colorName;

	public Color() {

	}

	public Color(String colorName) {
		this();
		this.colorName = colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return this.colorName;
	}
}
