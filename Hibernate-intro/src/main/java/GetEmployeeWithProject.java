import java.util.Comparator;
import java.util.Scanner;
import javax.persistence.*;
import entities.Employee;
import entities.Project;

public class GetEmployeeWithProject {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();

		int empId = Integer.parseInt(sc.nextLine());

		Employee employee = entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
				.setParameter("id", empId).getSingleResult();

		System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

		employee.getProjects().stream().sorted(Comparator.comparing(Project::getName))
				.forEach(p -> System.out.println("      " + p.getName()));

		entityManager.close();
		sc.close();
	}
}
