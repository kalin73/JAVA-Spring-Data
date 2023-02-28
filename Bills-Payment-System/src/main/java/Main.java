import entities.*;

import jakarta.persistence.*;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("bills").createEntityManager();
		entityManager.getTransaction().begin();
		User user = new User();
		user.setFirst_name("Ivan");
		user.setLast_name("Ivanov");
		user.setPassword("1234");
		user.setEmail("ivan@ab.bg");

		CreditCard card = new CreditCard();
		card.setCard_type("Visa");
		card.setExpiration_month("05");
		card.setExpiration_year("2023");
		card.setNumber("7777");
		card.setOwner(user);

		entityManager.persist(user);
		entityManager.flush();
		entityManager.persist(card);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
