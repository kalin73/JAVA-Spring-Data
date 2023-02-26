package footballBettingDatabase.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table
public class Continent extends BaseEntity {
	@Column(nullable = false, unique = true)
	private String name;

	@ManyToMany(mappedBy = "continents")
	private Set<Country> countries;

	public Continent() {
		countries = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
