package footballBettingDatabase.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@Column(length = 3)
	private String id;

	@Column(nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "countries_continents",
		joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
	private Set<Continent> continents;

	public Country() {
		continents = new HashSet<>();
	}

	public Set<Continent> getContinents() {
		return new HashSet<>(this.continents);
	}

	public void setContinents(Set<Continent> continents) {
		this.continents = continents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
