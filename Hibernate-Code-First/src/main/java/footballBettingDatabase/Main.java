package footballBettingDatabase;

import footballBettingDatabase.entities.*;
import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("football").createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.getTransaction().commit();
		entityManager.close();


	}

}
