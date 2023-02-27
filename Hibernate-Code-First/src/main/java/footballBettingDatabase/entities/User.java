package footballBettingDatabase.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table
public class User extends BaseEntity {
	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	private String fulName;

	@Column
	private BigDecimal balance;

	public String getUsername() {
		return username;
	}

	public User() {

	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFulName() {
		return fulName;
	}

	public void setFulName(String fulName) {
		this.fulName = fulName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
