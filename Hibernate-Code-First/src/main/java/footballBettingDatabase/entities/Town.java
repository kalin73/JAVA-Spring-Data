package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

	@Column(length = 3, nullable = false)
	private String name;

	@ManyToOne
	private Country country;

}
