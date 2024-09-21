package many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchesByStudentID {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		int sid = 3;
		Query q = em.createQuery("from Batch");
		List<Batch> bl = q.getResultList();
		for(Batch b: bl) {
			List<Student> sl = b.getStudents();
			for(Student s: sl) {
				if(s.getId() == sid) {
					System.out.println(s.getName()+" --> "+ b.getName());
				}
			}
		}
		
	}
}
