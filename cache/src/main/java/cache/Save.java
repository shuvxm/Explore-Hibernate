package cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User u = new User();
		u.setName("srikant");
		u.setEmail("srikantu@gmail.com");
		
		et.begin();
//		em.persist(u);
		System.out.println(em.merge(u));
		et.commit();
	}
}
