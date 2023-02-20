import entities.Student;
import jakarta.persistence.*;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-db");

		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();

		Student student = new Student();
		student.setName("Tosho");
		student.setAge(24);

		entityManager.persist(student);

		Student found = entityManager.find(Student.class, 1);
		System.out.println(found);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
