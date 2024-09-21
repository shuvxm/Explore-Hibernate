package many_to_many_bi;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setName("chintu");
		
		Student s2 = new Student();
		s2.setName("Maya");
		
		Batch b1 = new Batch();
		b1.setName("java");
		
		Batch b2 = new Batch();
		b2.setName("SQL");
		
		ArrayList<Student> a = new ArrayList<Student>();
		a.add(s1);
		a.add(s2);
		
		ArrayList<Batch> b = new ArrayList<Batch>();
		b.add(b1);
		b.add(b2);
		
		s1.setBatches(b);
		s2.setBatches(b);
		
		b1.setStudents(a);
		b2.setStudents(a);
		
		et.begin();
		em.persist(b1);
		em.persist(b2);
		
		em.persist(s1);
		em.persist(s2);
		et.commit();
		
		
	}
}
