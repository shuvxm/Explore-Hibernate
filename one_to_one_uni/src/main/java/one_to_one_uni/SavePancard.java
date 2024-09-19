package one_to_one_uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePancard {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Pancard pc = new Pancard();
		pc.setId(1001);
		pc.setPanNo("kbc4567ef");
		pc.setPinCode(560045);
		
		et.begin();
		em.persist(pc);
		et.commit();
		
	}
}
