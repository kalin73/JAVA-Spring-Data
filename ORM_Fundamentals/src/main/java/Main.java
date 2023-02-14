import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import entities.Student;
import entities.User;
import orm.Connector;
import orm.EntityManager;

public class Main {

	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException,
			InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Connector.createConnection("root", "root", "soft_uni");
		Connection connection = Connector.getConnection();

		EntityManager<User> userManager = new EntityManager<>(connection);
		EntityManager<Student> studentManager = new EntityManager<>(connection);

		User first = userManager.findFirst(User.class, "");

		System.out.println(
				first.getId() + " " + first.getUsername() + " " + first.getAge() + " " + first.getRegistration());

		Student firstStudent = studentManager.findFirst(Student.class, "name = 'Pesho'");

		System.out.println(firstStudent.getId() + " " + firstStudent.getName());

		User newUser = new User("Pesho", 25, LocalDate.now());
		userManager.persist(newUser);

	}

}
