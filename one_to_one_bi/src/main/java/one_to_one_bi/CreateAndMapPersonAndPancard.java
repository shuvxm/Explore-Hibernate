package one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateAndMapPersonAndPancard {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = new Person();
		p.setName("Komolika");
		p.setEmail("komolika@gmail.com");
		
		Pancard pc = new Pancard();
		pc.setPanNo("KOMOL13LA");
		pc.setPinCode(560045);
		
		pc.setPerson(p);
		p.setPancard(pc);
		
		et.begin();
		em.persist(pc);
//		em.persist(p);
		et.commit();
		
		
	}
}
