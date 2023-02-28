package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String first_name;

	@Column(nullable = false)
	private String last_name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@OneToOne(targetEntity = BillingDetail.class, mappedBy = "owner")
	private BillingDetail billing_detail;

	public User() {

	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BillingDetail getBilling_details() {
		return billing_detail;
	}

	public void setBilling_details(BillingDetail billing_details) {
		this.billing_detail = billing_details;
	}

}
