package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics {
	@Id
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	@Id
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	@Column(name = "scored_goals")
	private short scoredGoals;

	@Column(name = "assists")
	private short assists;

	@Column(name = "minutes_played")
	private short minutesPlayed;

	public PlayerStatistics() {

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public short getScoredGoals() {
		return scoredGoals;
	}

	public void setScoredGoals(short scoredGoals) {
		this.scoredGoals = scoredGoals;
	}

	public short getAssists() {
		return assists;
	}

	public void setAssists(short assists) {
		this.assists = assists;
	}

	public short getMinutesPlayed() {
		return minutesPlayed;
	}

	public void setMinutesPlayed(short minutesPlayed) {
		this.minutesPlayed = minutesPlayed;
	}

}
