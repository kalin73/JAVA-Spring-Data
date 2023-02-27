package entities;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "store_locations")
public class StoreLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String location_name;

	@OneToMany
	@JoinTable
	private Set<Sale> sales;

	public StoreLocation() {

	}

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

}
