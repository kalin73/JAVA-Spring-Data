package footballBettingDatabase.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {

	@Column(name = "bet_money")
	private BigDecimal betMoney;

	@Column(name = "time_of_bet")
	private Date timeOfBet;

	@ManyToOne
	private User user;

	public Bet() {

	}

	public BigDecimal getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(BigDecimal betMoney) {
		this.betMoney = betMoney;
	}

	public Date getTimeOfBet() {
		return timeOfBet;
	}

	public void setTimeOfBet(Date timeOfBet) {
		this.timeOfBet = timeOfBet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
