import java.util.stream.Collectors;

import javax.persistence.*;

import entities.Employee;

public class IncreaseSalaries {

	public static void main(String[] args) {
		final EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery(
				"UPDATE Employee e SET e.salary = e.salary * 1.12 " + "WHERE e.department.id in (1, 2, 4, 11)");

		query.executeUpdate();

		entityManager.getTransaction().commit();
		
		System.out.println(entityManager.createQuery("SELECT e FROM Employee e "
				+ "WHERE e.department.name in ('Engineering', 'Tool Design', 'Marketing', 'Information Services')",
				Employee.class).getResultList().stream()
				.map(x -> String.format("%s %s (%.2f)%n", x.getFirstName(), x.getLastName(), x.getSalary()))
				.collect(Collectors.joining("")));
		
		entityManager.close();

	}

}
