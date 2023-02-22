import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Address;

public class AddingANewAddressAndUpdatingEmployee {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		String lastName = sc.nextLine();

		Address adress = new Address();
		adress.setText("Vitoshka 15");

		entityManager.persist(adress);

		int count = entityManager
				.createQuery("UPDATE Employee e SET e.address = :newAddress " + "WHERE e.lastName = :ln")
				.setParameter("newAddress", adress).setParameter("ln", lastName).executeUpdate();

		entityManager.getTransaction().commit();
		entityManager.close();
		sc.close();

		System.out.println(count);

	}

}
