import hasEntities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("relations").createEntityManager();
		entityManager.getTransaction().begin();

		PlateNumber plateNumber = new PlateNumber("123");
		Truck truck1 = new Truck(plateNumber);
		Truck truck2 = new Truck(plateNumber);
		
		
		entityManager.persist(plateNumber);
		entityManager.persist(truck1);
		entityManager.persist(truck2);

//		Article article = new Article("alabala");
//
//		User author = new User("Pesho");
//		author.addArticle(article);
//		article.setAuthor(author);
//		
//		entityManager.persist(author);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
