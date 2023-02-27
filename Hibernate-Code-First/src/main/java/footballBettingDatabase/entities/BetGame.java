package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
	@Id
	@OneToOne
	private Game game;

	@Id
	@OneToOne
	private Bet bet;

	@OneToOne
	@JoinColumn(name = "result_prediction")
	private ResultPrediction ResultPrediction;

	public BetGame() {

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public ResultPrediction getResultPrediction() {
		return ResultPrediction;
	}

	public void setResultPrediction(ResultPrediction resultPrediction) {
		ResultPrediction = resultPrediction;
	}

}
