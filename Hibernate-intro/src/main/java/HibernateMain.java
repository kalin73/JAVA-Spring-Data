

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Student;

public class HibernateMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

//		Student example = new Student();
//		example.setName("Gosho");
//		session.persist(example);

//		Student student = session.get(Student.class, 2L);
//		System.out.println(student.getId() + " " + student.getName());

		List<Student> list = session.createQuery("FROM Student AS s WHERE s.name = 'Pesho'", Student.class).list();
		
		list.forEach(System.out::println);

		session.getTransaction().commit();
		session.close();

	}

}
