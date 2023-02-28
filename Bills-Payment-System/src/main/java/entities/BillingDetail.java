package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Column
	private String number;

	@OneToOne
	private User owner;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
