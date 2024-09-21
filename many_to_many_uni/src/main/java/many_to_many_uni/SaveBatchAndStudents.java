package many_to_many_uni;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchAndStudents {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setName("shubham");
		s1.setEmail("shubh@gmail.com");
		s1.setPhone(9087654321l);
		
		Student s2 = new Student();
		s2.setName("Prince");
		s2.setEmail("prince@gmail.com");
		s2.setPhone(1234567890l);
		
		Student s3 = new Student();
		s3.setName("Pushkar");
		s3.setEmail("pushkar@gmail.com");
		s3.setPhone(6789054321l);
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		Batch b1 = new Batch();
		b1.setName("Core Java");
		b1.setStudents(students);
		
		Batch b2 = new Batch();
		b2.setName("J2EE");
		b2.setStudents(students);
		
		Batch b3 = new Batch();
		b3.setName("Hibernate");
		b3.setStudents(students);
		
		et.begin();
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		
		et.commit();
		
		
		
	}
}
