package one_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Person p = new Person();
		p.setId(101);
		p.setName("Jacky");
		p.setPhone(134567890);
		p.setEmail("jack@gmail.com");
		p.setPassword("123");
		
		et.begin();
		em.persist(p);
		et.commit();
		
	}

}
