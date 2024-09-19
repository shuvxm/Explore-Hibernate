package many_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapDirectorAndMovies {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Director d2 = new Director();
		d2.setName("S.A");
		d2.setIndustry("BollyWood");
		
		
		Movie m4 = new Movie();
		m4.setName("Bang Bang");
		m4.setYor(2021);
		m4.setDirector(d2);
		
		Movie m5 = new Movie();
		m5.setName("");
		m5.setYor(2021);
		m5.setDirector(d2);
		
		et.begin();
		em.persist(d2);
		em.persist(m4);
		em.persist(m5);
		et.commit();
		
		
		
		
	}
}
