import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesWithSalaryOver50000 {
	private static final String GET_EMPLOYEES_WITH_SALARY_OVER_50000 = "SELECT e.firstName FROM Employee e WHERE e.salary > 50000";

	public static void main(String[] args) {
		final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("soft_uni");
		final EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.createQuery(GET_EMPLOYEES_WITH_SALARY_OVER_50000, String.class).getResultList()
				.forEach(x -> System.out.println(x));

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
