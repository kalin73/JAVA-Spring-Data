package footballBettingDatabase.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "result_predictions")
public class ResultPrediction extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private ResultPredictionValues resultPrediction;

	public ResultPrediction() {
	
	}

	public ResultPredictionValues getResultPrediction() {
		return resultPrediction;
	}

	public void setResultPrediction(ResultPredictionValues resultPrediction) {
		this.resultPrediction = resultPrediction;
	}
	
	
}
