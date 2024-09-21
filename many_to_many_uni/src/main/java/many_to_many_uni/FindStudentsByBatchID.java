package many_to_many_uni;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentsByBatchID {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Batch b = em.find(Batch.class, 6);
		List<Student> sl = b.getStudents();
		for(Student s: sl) {
			System.err.println(s.getName());
		}
		
		// Q. Find  batches by individual student id 
	
	
		
	}
}
