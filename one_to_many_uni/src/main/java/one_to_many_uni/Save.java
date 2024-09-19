package one_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		State s = new State();
		s.setId(101);
		s.setName("Karnataka");
		s.setCapitalCity("Bangalore");
		et.begin();
		em.persist(s);
		et.commit();

//		District d = new District();
//		d.setId(4);
//		d.setName("Hebbal");
//
//		et.begin();
//		em.persist(d);
//		et.commit();
	}
}