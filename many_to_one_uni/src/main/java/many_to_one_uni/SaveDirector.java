package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDirector {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Director d = new Director();
		d.setName("SS Rajmauli");
		d.setIndustry("Tolly Wood");
//		
		et.begin();
		em.persist(d);
		et.commit();
		
		Movie m1 = new Movie();
		m1.setName("Bahubali");
		m1.setYor(2020);
		m1.setDirector(d);
		
		Movie m2 = new Movie();
		m2.setName("RRR");
		m2.setYor(2021);
		m2.setDirector(d);
		
		Movie m3 = new Movie();
		m3.setName("KGF");
		m3.setYor(2018);
		m3.setDirector(d);
		
		et.begin();
		em.persist(m1);
		em.merge(m2);
		em.persist(m3);
		et.commit();
		
		
	}

}
