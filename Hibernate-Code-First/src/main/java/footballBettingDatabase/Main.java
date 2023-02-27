package footballBettingDatabase;

import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("football").createEntityManager();

	}

}
