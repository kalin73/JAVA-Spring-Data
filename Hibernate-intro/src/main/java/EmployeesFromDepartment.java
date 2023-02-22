import javax.persistence.EntityManager;

import entities.Employee;

public class EmployeesFromDepartment {
	private static final String GET_EMPLOYEES_FROM_SPECIFIC_DEPARTMENT = "SELECT e FROM Employee e "
			+ "WHERE e.department.name = :dp " 
			+ "ORDER BY e.salary asc, e.id";

	private static final String PRINT_EMP_FORMAT = "%s %s from %s - $%s%n";

	public static void main(String[] args) {
		final EntityManager entityManager = Utils.createEntityManager();
		final String departmentName = "Research and Development";

		entityManager.createQuery(GET_EMPLOYEES_FROM_SPECIFIC_DEPARTMENT, Employee.class)
				.setParameter("dp", departmentName)
				.getResultList()
				.forEach(x -> {
					System.out.printf(PRINT_EMP_FORMAT, x.getFirstName(), x.getLastName(), x.getDepartment().getName(),
							x.getSalary());
				});

		entityManager.close();

	}

}
