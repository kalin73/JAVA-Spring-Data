package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail {
	@Column
	private String name;

	@Column
	private String SWIFT_code;

	public BankAccount() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSWIFT_code() {
		return SWIFT_code;
	}

	public void setSWIFT_code(String sWIFT_code) {
		SWIFT_code = sWIFT_code;
	}

}
