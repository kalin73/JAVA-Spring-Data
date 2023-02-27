package footballBettingDatabase;

import footballBettingDatabase.entities.BaseEntity;
import footballBettingDatabase.entities.Color;
import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("football").createEntityManager();
		entityManager.getTransaction().begin();
		
		BaseEntity color = new Color("Blue");
		entityManager.persist(color);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
