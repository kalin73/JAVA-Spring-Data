package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {
	@Column
	private String card_type;

	@Column
	private String expiration_month;

	@Column
	private String expiration_year;

	public CreditCard() {

	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public String getExpiration_month() {
		return expiration_month;
	}

	public void setExpiration_month(String expiration_month) {
		this.expiration_month = expiration_month;
	}

	public String getExpiration_year() {
		return expiration_year;
	}

	public void setExpiration_year(String expiration_year) {
		this.expiration_year = expiration_year;
	}
}
