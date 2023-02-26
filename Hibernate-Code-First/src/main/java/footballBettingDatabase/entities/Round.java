package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Round extends BaseEntity {
	@Column
	private String name;
}
