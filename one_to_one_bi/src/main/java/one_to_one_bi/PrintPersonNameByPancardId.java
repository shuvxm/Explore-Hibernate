package one_to_one_bi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PrintPersonNameByPancardId {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Pancard pc = em.find(Pancard.class, 3);
		System.err.println(pc.getPerson().getName());
	}
}
