package one_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapPersonAndPancard {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Person p = em.find(Person.class, new Integer(101));
		Pancard pc = em.find(Pancard.class, new Integer(1001));
		
		p.setPancard(pc);
		
		et.begin();
		em.merge(pc);
		et.commit();
	}
}
